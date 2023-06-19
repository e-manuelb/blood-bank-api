package br.com.ecb.bloodbankapi.data.repositories.person;

import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByEmail(String email);
}
