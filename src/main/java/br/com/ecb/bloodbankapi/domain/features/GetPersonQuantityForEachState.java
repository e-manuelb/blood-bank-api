package br.com.ecb.bloodbankapi.domain.features;

import br.com.ecb.bloodbankapi.domain.models.info.PersonQuantityForEachState;

import java.util.List;

public interface GetPersonQuantityForEachState {
    List<PersonQuantityForEachState> handle();
}
