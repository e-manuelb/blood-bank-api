package br.com.ecb.bloodbankapi.main.routes;

import br.com.ecb.bloodbankapi.controllers.person.GetPersonByEmailController;
import br.com.ecb.bloodbankapi.controllers.person.SavePersonController;
import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import br.com.ecb.bloodbankapi.main.factories.person.GetPersonByEmailControllerFactory;
import br.com.ecb.bloodbankapi.main.factories.person.SavePersonControllerFactory;
import br.com.ecb.bloodbankapi.shared.dtos.request.SavePeopleFromJSONDTO;
import br.com.ecb.bloodbankapi.shared.dtos.response.MessageResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class SavePeopleFromJSONRoute {
    private final SavePerson savePersonService;
    private final GetPersonByEmail getPersonByEmailService;

    public SavePeopleFromJSONRoute(SavePerson savePersonService, GetPersonByEmail getPersonByEmailService) {
        this.savePersonService = savePersonService;
        this.getPersonByEmailService = getPersonByEmailService;
    }

    @PostMapping("/save/")
    public ResponseEntity<?> handle(@RequestBody @Valid List<SavePeopleFromJSONDTO> savePeopleFromJSONDTOs) {
        SavePersonController savePersonController = new SavePersonControllerFactory(savePersonService).makeSavePersonController();
        GetPersonByEmailController getPersonByEmailController = new GetPersonByEmailControllerFactory(getPersonByEmailService).makeGetPersonByEmailController();

        List<Person> people = new ArrayList<>();

        savePeopleFromJSONDTOs.forEach(savePeopleFromJSONDTO -> {
            if (getPersonByEmailController.handle(savePeopleFromJSONDTO.getEmail()) != null) {
            } else {
                people.add(
                        savePersonController.handle(
                                new Person()
                                        .setName(savePeopleFromJSONDTO.getNome())
                                        .setEmail(savePeopleFromJSONDTO.getEmail())
                                        .setDateOfBirth(LocalDate.parse(savePeopleFromJSONDTO.getData_nasc(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                                        .setPhone(savePeopleFromJSONDTO.getCelular())
                                        .setLandline(savePeopleFromJSONDTO.getTelefone_fixo())
                                        .setAddress(
                                                new PersonAddress()
                                                        .setZipCode(savePeopleFromJSONDTO.getCep())
                                                        .setAddress(savePeopleFromJSONDTO.getEndereco())
                                                        .setNumber(savePeopleFromJSONDTO.getNumero())
                                                        .setNeighborhood(savePeopleFromJSONDTO.getBairro())
                                                        .setState(savePeopleFromJSONDTO.getEstado())
                                        )
                                        .setInfo(
                                                new PersonInfo()
                                                        .setCpf(savePeopleFromJSONDTO.getCpf())
                                                        .setRg(savePeopleFromJSONDTO.getRg())
                                                        .setGender(savePeopleFromJSONDTO.getSexo())
                                                        .setMotherName(savePeopleFromJSONDTO.getMae())
                                                        .setFatherName(savePeopleFromJSONDTO.getPai())
                                                        .setHeight(savePeopleFromJSONDTO.getAltura())
                                                        .setWeight(savePeopleFromJSONDTO.getPeso())
                                                        .setBloodType(savePeopleFromJSONDTO.getTipo_sanguineo())
                                        )
                        )
                );
            }
        });

        if (people.size() > 0) {
            return new ResponseEntity<>(people, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new MessageResponseDTO("No new people have been added to the database."), HttpStatus.OK);
        }
    }
}
