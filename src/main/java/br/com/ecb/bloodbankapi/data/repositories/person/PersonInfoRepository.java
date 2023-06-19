package br.com.ecb.bloodbankapi.data.repositories.person;

import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepository extends JpaRepository<PersonInfo, Long> {
}
