package br.com.ecb.bloodbankapi.main.config.beans;

import br.com.ecb.bloodbankapi.data.services.GetAverageAgeForEachBloodTypeService;
import br.com.ecb.bloodbankapi.domain.features.GetAverageAgeForEachBloodType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAverageAgeForEachBloodTypeBean {
    @Bean
    GetAverageAgeForEachBloodType getAverageAgeForEachBloodType() {
        return new GetAverageAgeForEachBloodTypeService();
    }
}
