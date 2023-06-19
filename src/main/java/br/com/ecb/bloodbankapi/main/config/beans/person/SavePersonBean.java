package br.com.ecb.bloodbankapi.main.config.beans.person;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.data.services.person.SavePersonService;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.features.person.address.SavePersonAddress;
import br.com.ecb.bloodbankapi.domain.features.person.info.SavePersonInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SavePersonBean {
    private final PersonRepository personRepository;
    private final SavePersonAddress savePersonAddressService;
    private final SavePersonInfo savePersonInfoService;

    public SavePersonBean(PersonRepository personRepository, SavePersonAddress savePersonAddressService, SavePersonInfo savePersonInfoService) {
        this.personRepository = personRepository;
        this.savePersonAddressService = savePersonAddressService;
        this.savePersonInfoService = savePersonInfoService;
    }

    @Bean
    SavePerson savePerson() {
        return new SavePersonService(personRepository, savePersonAddressService, savePersonInfoService);
    }
}
