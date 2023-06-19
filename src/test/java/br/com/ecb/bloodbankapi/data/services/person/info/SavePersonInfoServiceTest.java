package br.com.ecb.bloodbankapi.data.services.person.info;

import br.com.ecb.bloodbankapi.data.factories.PersonFactory;
import br.com.ecb.bloodbankapi.data.factories.PersonInfoFactory;
import br.com.ecb.bloodbankapi.data.repositories.person.PersonInfoRepository;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SavePersonInfoServiceTest {
    private PersonInfoRepository personInfoRepository;
    private SavePersonInfoService savePersonInfoService;

    @BeforeEach
    public void init() {
        personInfoRepository = Mockito.mock(PersonInfoRepository.class);

        savePersonInfoService = new SavePersonInfoService(personInfoRepository);
    }

    @Test
    public void testSavePersonInfoSuccessfully() {
        Person person = new PersonFactory().create();
        PersonInfo info = new PersonInfoFactory().create(person);

        Mockito.when(personInfoRepository.save(Mockito.any(PersonInfo.class))).thenReturn(info);

        PersonInfo createdPersonInfo = savePersonInfoService.handle(info);

        Assertions.assertEquals(info.getCpf(), createdPersonInfo.getCpf());
        Assertions.assertEquals(info.getRg(), createdPersonInfo.getRg());
        Assertions.assertEquals(info.getGender(), createdPersonInfo.getGender());
        Assertions.assertEquals(info.getMotherName(), createdPersonInfo.getMotherName());
        Assertions.assertEquals(info.getFatherName(), createdPersonInfo.getFatherName());
        Assertions.assertEquals(info.getHeight(), createdPersonInfo.getHeight());
        Assertions.assertEquals(info.getWeight(), createdPersonInfo.getWeight());
        Assertions.assertEquals(info.getBloodType(), createdPersonInfo.getBloodType());
        Assertions.assertEquals(info.getPerson(), createdPersonInfo.getPerson());
    }
}
