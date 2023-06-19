package br.com.ecb.bloodbankapi.domain.features;

import br.com.ecb.bloodbankapi.domain.models.person.Person;

import java.util.List;

public interface GetAverageAgeForEachBloodType {
    List<Object> handle(List<Person> people);
}
