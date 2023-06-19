package br.com.ecb.bloodbankapi.shared.dtos.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SavePeopleFromJSONDTOTest {

    @Test
    public void testGetProcessedInformationDTOSuccessfully() {
        SavePeopleFromJSONDTO savePeopleFromJSONDTO = new SavePeopleFromJSONDTO();

        String name = "John Doe";
        String cpf = "000.000.000-00";
        String rg = "0000000000-0";
        String birthDate = "01/01/2000";
        String gender = "Masculino";
        String motherName = "Joana Doe";
        String fatherName = "Don Doe";
        String email = "test@test.com";
        String zipCode = "11.111-111";
        String address = "Test address";
        Integer number = 123;
        String neighborhood = "Test neighborhood.";
        String city = "Test city";
        String state = "Test state";
        String landline = "9999-9999";
        String phone = "(00) 00000-0000";
        Double height = 2.00;
        Double weight = 90.0;
        String bloodType = "A+";

        savePeopleFromJSONDTO
                .setNome(name)
                .setCpf(cpf)
                .setRg(rg)
                .setData_nasc(birthDate)
                .setSexo(gender)
                .setMae(motherName)
                .setPai(fatherName)
                .setEmail(email)
                .setCep(zipCode)
                .setEndereco(address)
                .setNumero(number)
                .setBairro(neighborhood)
                .setCidade(city)
                .setEstado(state)
                .setTelefone_fixo(landline)
                .setCelular(phone)
                .setAltura(height)
                .setPeso(weight)
                .setTipo_sanguineo(bloodType);

        Assertions.assertNotNull(savePeopleFromJSONDTO);
        Assertions.assertEquals(savePeopleFromJSONDTO.getNome(), name);
        Assertions.assertEquals(savePeopleFromJSONDTO.getCpf(), cpf);
        Assertions.assertEquals(savePeopleFromJSONDTO.getRg(), rg);
        Assertions.assertEquals(savePeopleFromJSONDTO.getData_nasc(), birthDate);
        Assertions.assertEquals(savePeopleFromJSONDTO.getSexo(), gender);
        Assertions.assertEquals(savePeopleFromJSONDTO.getMae(), motherName);
        Assertions.assertEquals(savePeopleFromJSONDTO.getPai(), fatherName);
        Assertions.assertEquals(savePeopleFromJSONDTO.getEmail(), email);
        Assertions.assertEquals(savePeopleFromJSONDTO.getCep(), zipCode);
        Assertions.assertEquals(savePeopleFromJSONDTO.getEndereco(), address);
        Assertions.assertEquals(savePeopleFromJSONDTO.getNumero(), number);
        Assertions.assertEquals(savePeopleFromJSONDTO.getBairro(), neighborhood);
        Assertions.assertEquals(savePeopleFromJSONDTO.getCidade(), city);
        Assertions.assertEquals(savePeopleFromJSONDTO.getEstado(), state);
        Assertions.assertEquals(savePeopleFromJSONDTO.getTelefone_fixo(), landline);
        Assertions.assertEquals(savePeopleFromJSONDTO.getCelular(), phone);
        Assertions.assertEquals(savePeopleFromJSONDTO.getAltura(), height);
        Assertions.assertEquals(savePeopleFromJSONDTO.getPeso(), weight);
        Assertions.assertEquals(savePeopleFromJSONDTO.getTipo_sanguineo(), bloodType);
    }
}
