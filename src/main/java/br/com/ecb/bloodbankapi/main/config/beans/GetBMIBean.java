package br.com.ecb.bloodbankapi.main.config.beans;

import br.com.ecb.bloodbankapi.data.services.GetBMIService;
import br.com.ecb.bloodbankapi.domain.features.GetBMI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetBMIBean {
    @Bean
    GetBMI getBMI() {
        return new GetBMIService();
    }
}
