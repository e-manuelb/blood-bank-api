package br.com.ecb.bloodbankapi.main.config.beans;

import br.com.ecb.bloodbankapi.data.services.GetAverageBMIPerAgeService;
import br.com.ecb.bloodbankapi.domain.features.GetAverageBMIPerAge;
import br.com.ecb.bloodbankapi.domain.features.GetBMI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAverageBMIPerAgeBean {
    private final GetBMI getBMIService;

    public GetAverageBMIPerAgeBean(GetBMI getBMIService) {
        this.getBMIService = getBMIService;
    }

    @Bean
    GetAverageBMIPerAge getAverageBMIPerAge() {
        return new GetAverageBMIPerAgeService(getBMIService);
    }
}
