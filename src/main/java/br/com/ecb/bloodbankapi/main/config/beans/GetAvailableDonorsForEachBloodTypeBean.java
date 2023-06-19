package br.com.ecb.bloodbankapi.main.config.beans;

import br.com.ecb.bloodbankapi.data.services.GetAvailableDonorsForEachBloodTypeService;
import br.com.ecb.bloodbankapi.domain.features.GetAvailableDonorsForEachBloodType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAvailableDonorsForEachBloodTypeBean {

    @Bean
    GetAvailableDonorsForEachBloodType getAvailableDonorsForEachBloodType() {
        return new GetAvailableDonorsForEachBloodTypeService();
    }
}
