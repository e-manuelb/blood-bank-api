package br.com.ecb.bloodbankapi.domain.features.person.address;

import br.com.ecb.bloodbankapi.domain.models.person.PersonAddress;

public interface SavePersonAddress {
    PersonAddress handle(PersonAddress address);
}
