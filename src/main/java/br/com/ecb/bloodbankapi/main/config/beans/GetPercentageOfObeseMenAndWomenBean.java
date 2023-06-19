package br.com.ecb.bloodbankapi.main.config.beans;

import br.com.ecb.bloodbankapi.data.services.GetPercentageOfObeseMenAndWomenService;
import br.com.ecb.bloodbankapi.domain.features.GetBMI;
import br.com.ecb.bloodbankapi.domain.features.GetPercentageOfObeseMenAndWomen;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetPercentageOfObeseMenAndWomenBean {
    private final GetBMI getBMIService;

    public GetPercentageOfObeseMenAndWomenBean(GetBMI getBMIService) {
        this.getBMIService = getBMIService;
    }

    @Bean
    GetPercentageOfObeseMenAndWomen getPercentageOfObeseMenAndWomen() {
        return new GetPercentageOfObeseMenAndWomenService(getBMIService);
    }
}
