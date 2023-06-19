package br.com.ecb.bloodbankapi.domain.features;

import br.com.ecb.bloodbankapi.domain.models.person.Person;

import java.util.List;
import java.util.Map;

public interface GetPercentageOfObeseMenAndWomen {
    Map<String, String> handle(List<Person> people);
}
