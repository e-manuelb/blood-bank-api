package br.com.ecb.bloodbankapi.data.services.person.info;

import br.com.ecb.bloodbankapi.data.repositories.person.PersonInfoRepository;
import br.com.ecb.bloodbankapi.domain.features.person.info.SavePersonInfo;
import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;
import org.springframework.stereotype.Service;

@Service
public class SavePersonInfoService implements SavePersonInfo {
    private PersonInfoRepository personInfoRepository;

    public SavePersonInfoService(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

    public PersonInfo handle(PersonInfo info) {
        return personInfoRepository.save(info);
    }
}
