package br.com.ecb.bloodbankapi.main.config.beans.person.info;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonInfoRepository;
import br.com.ecb.bloodbankapi.data.services.person.info.SavePersonInfoService;
import br.com.ecb.bloodbankapi.domain.features.person.info.SavePersonInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SavePersonInfoBean {
    private final PersonInfoRepository personInfoRepository;

    public SavePersonInfoBean(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

    @Bean
    SavePersonInfo savePersonInfo() {
        return new SavePersonInfoService(personInfoRepository);
    }
}
