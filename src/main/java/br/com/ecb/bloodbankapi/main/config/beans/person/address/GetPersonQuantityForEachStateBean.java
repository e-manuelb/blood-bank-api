package br.com.ecb.bloodbankapi.main.config.beans.person.address;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonAddressRepository;
import br.com.ecb.bloodbankapi.data.services.GetPersonQuantityForEachStateService;
import br.com.ecb.bloodbankapi.domain.features.GetPersonQuantityForEachState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetPersonQuantityForEachStateBean {
    private final PersonAddressRepository personAddressRepository;

    public GetPersonQuantityForEachStateBean(PersonAddressRepository personAddressRepository) {
        this.personAddressRepository = personAddressRepository;
    }

    @Bean
    GetPersonQuantityForEachState getPersonQuantityForEachState() {
        return new GetPersonQuantityForEachStateService(personAddressRepository);
    }
}
