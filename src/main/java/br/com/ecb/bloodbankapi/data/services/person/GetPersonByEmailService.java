package br.com.ecb.bloodbankapi.data.services.person;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

@Service
public class GetPersonByEmailService implements GetPersonByEmail {
    private final PersonRepository personRepository;

    public GetPersonByEmailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person handle(String email) {
        return personRepository.findPersonByEmail(email);
    }
}
