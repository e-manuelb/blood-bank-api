package br.com.ecb.bloodbankapi.domain.features.person.info;

import br.com.ecb.bloodbankapi.domain.models.person.PersonInfo;

public interface SavePersonInfo {
    PersonInfo handle(PersonInfo info);
}
