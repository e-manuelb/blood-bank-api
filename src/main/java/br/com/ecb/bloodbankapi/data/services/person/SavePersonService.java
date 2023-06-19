package br.com.ecb.bloodbankapi.data.services.person;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.features.person.address.SavePersonAddress;
import br.com.ecb.bloodbankapi.domain.features.person.info.SavePersonInfo;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import org.springframework.stereotype.Service;

@Service
public class SavePersonService implements SavePerson {
    private final PersonRepository personRepository;
    private final SavePersonAddress savePersonAddressService;
    private final SavePersonInfo savePersonInfoService;

    public SavePersonService(PersonRepository personRepository, SavePersonAddress savePersonAddressService, SavePersonInfo savePersonInfoService) {
        this.personRepository = personRepository;
        this.savePersonAddressService = savePersonAddressService;
        this.savePersonInfoService = savePersonInfoService;
    }

    public Person handle(Person person) {
        Person createdPerson = personRepository.save(
                new Person()
                        .setName(person.getName())
                        .setEmail(person.getEmail())
                        .setDateOfBirth(person.getDateOfBirth())
                        .setPhone(person.getLandline())
                        .setLandline(person.getLandline() != null ? person.getLandline() : "")
        );

        PersonAddress address = savePersonAddressService.handle(
                new PersonAddress()
                        .setZipCode(person.getAddress().getZipCode())
                        .setAddress(person.getAddress().getAddress())
                        .setNumber(person.getAddress().getNumber())
                        .setNeighborhood(person.getAddress().getNeighborhood())
                        .setState(person.getAddress().getState())
                        .setPerson(createdPerson)
        );

        PersonInfo info = savePersonInfoService.handle(
                new PersonInfo()
                        .setCpf(person.getInfo().getCpf())
                        .setRg(person.getInfo().getRg())
                        .setGender(person.getInfo().getGender())
                        .setMotherName(person.getInfo().getMotherName())
                        .setFatherName(person.getInfo().getFatherName())
                        .setHeight(person.getInfo().getHeight())
                        .setWeight(person.getInfo().getWeight())
                        .setPerson(createdPerson)
                        .setBloodType(person.getInfo().getBloodType())
        );

        createdPerson.setAddress(address);
        createdPerson.setInfo(info);

        personRepository.save(createdPerson);

        return createdPerson;
    }
}
