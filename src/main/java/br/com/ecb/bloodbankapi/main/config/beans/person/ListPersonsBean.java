package br.com.ecb.bloodbankapi.main.config.beans.person;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.data.services.person.ListPersonsService;
import br.com.ecb.bloodbankapi.domain.features.person.ListPersons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListPersonsBean {
    private final PersonRepository personRepository;

    public ListPersonsBean(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Bean
    ListPersons listPersons() {
        return new ListPersonsService(personRepository);
    }
}
