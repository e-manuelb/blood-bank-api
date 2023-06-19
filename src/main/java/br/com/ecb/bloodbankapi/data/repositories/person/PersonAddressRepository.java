package br.com.ecb.bloodbankapi.data.repositories.person;

import br.com.ecb.bloodbankapi.domain.models.info.PersonQuantityForEachState;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
    @Query("SELECT new br.com.ecb.bloodbankapi.domain.models.info.PersonQuantityForEachState(pa.state, count(pa.id)) FROM PersonAddress pa GROUP BY pa.state")
    List<PersonQuantityForEachState> getPersonQuantityForEachState();
}
