package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.domain.features.GetAverageAgeForEachBloodType;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class GetAverageAgeForEachBloodTypeService implements GetAverageAgeForEachBloodType {
    public List<Object> handle(List<Person> people) {
        List<String> bloodTypes = List.of("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

        List<Object> averages = new ArrayList<>();

        bloodTypes.forEach(bloodType -> {
            List<Person> peopleWithCertainBloodType = people.stream().filter(person -> Objects.equals(person.getInfo().getBloodType(), bloodType)).toList();

            List<Integer> ages = new ArrayList<>();

            peopleWithCertainBloodType.forEach(p -> ages.add(p.getAge()));

            if (ages == null || ages.size() == 0) {
                return;
            }

            averages.add(new HashMap<>() {{
                put("bloodType", bloodType);
                put("averageAge", (double) (ages.stream().reduce(0, Integer::sum) / ages.size()));
            }});

        });

        return averages;
    }
}
