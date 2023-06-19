package br.com.ecb.bloodbankapi.data.services.person;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonRepository;
import br.com.ecb.bloodbankapi.domain.features.person.ListPersons;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPersonsService implements ListPersons {
    private final PersonRepository personRepository;

    public ListPersonsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> handle() {
        return this.personRepository.findAll();
    }
}
