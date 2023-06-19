package br.com.ecb.bloodbankapi.main.config.beans.person.address;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonAddressRepository;
import br.com.ecb.bloodbankapi.data.services.person.address.SavePersonAddressService;
import br.com.ecb.bloodbankapi.domain.features.person.address.SavePersonAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SavePersonAddressBean {
    private final PersonAddressRepository personAddressRepository;

    public SavePersonAddressBean(PersonAddressRepository personAddressRepository) {
        this.personAddressRepository = personAddressRepository;
    }

    @Bean
    SavePersonAddress savePersonAddress() {
        return new SavePersonAddressService(personAddressRepository);
    }
}
