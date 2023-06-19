package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonAddressRepository;
import br.com.ecb.bloodbankapi.domain.features.GetPersonQuantityForEachState;
import br.com.ecb.bloodbankapi.domain.models.info.PersonQuantityForEachState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonQuantityForEachStateService implements GetPersonQuantityForEachState {
    private final PersonAddressRepository personAddressRepository;

    public GetPersonQuantityForEachStateService(PersonAddressRepository personAddressRepository) {
        this.personAddressRepository = personAddressRepository;
    }

    public List<PersonQuantityForEachState> handle() {
        return personAddressRepository.getPersonQuantityForEachState();
    }
}
