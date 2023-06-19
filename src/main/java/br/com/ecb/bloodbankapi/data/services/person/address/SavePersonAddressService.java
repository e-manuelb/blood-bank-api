package br.com.ecb.bloodbankapi.data.services.person.address;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonAddressRepository;
import br.com.ecb.bloodbankapi.domain.features.person.address.SavePersonAddress;
import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;
import org.springframework.stereotype.Service;

@Service
public class SavePersonAddressService implements SavePersonAddress {
    private final PersonAddressRepository personAddressRepository;

    public SavePersonAddressService(PersonAddressRepository personAddressRepository) {
        this.personAddressRepository = personAddressRepository;
    }

    public PersonAddress handle(PersonAddress address) {
        return personAddressRepository.save(address);
    }
}
