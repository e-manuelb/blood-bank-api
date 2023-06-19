package br.com.ecb.bloodbankapi.main.config.beans.person;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.data.services.person.GetPersonByEmailService;
import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetPersonByEmailBean {
    private final PersonRepository personRepository;

    public GetPersonByEmailBean(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Bean
    GetPersonByEmail getPersonByEmail() {
        return new GetPersonByEmailService(personRepository);
    }
}
