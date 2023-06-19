package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.domain.features.GetAverageBMIPerAge;
import br.com.ecb.bloodbankapi.domain.features.GetBMI;
import br.com.ecb.bloodbankapi.domain.models.Range;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetAverageBMIPerAgeService implements GetAverageBMIPerAge {
    private final GetBMI getBMIService;

    public GetAverageBMIPerAgeService(GetBMI getBMIService) {
        this.getBMIService = getBMIService;
    }

    public Map<String, Double> handle(List<Person> people) {
        Integer minAge = getMinimumAge(people);
        Integer maxAge = getMaximumAge(people);
        Integer rangeSize = 10;

        Integer current = minAge;

        List<Range> ranges = new ArrayList<>();

        Map<String, Double> averageBMIPerAges = new HashMap<>();

        while (current <= maxAge) {
            Integer end = Math.min(current + rangeSize, maxAge);
            ranges.add(new Range(current, end));

            current = end + 1;
        }

        ranges.forEach(range -> {
            List<Double> bmiList = new ArrayList<>();

            people.stream().filter(person -> {
                Integer age = person.getAge();

                if (age >= range.getStart() && age <= range.getEnd()) {
                    return true;
                } else {
                    return false;
                }
            }).forEach(person -> bmiList.add(getBMIService.handle(person.getInfo().getHeight(), person.getInfo().getWeight())));

            averageBMIPerAges.put(range.toString(), (bmiList.stream().mapToDouble(Double::doubleValue).sum() / bmiList.size()));
        });

        return averageBMIPerAges;
    }

    private Integer getMaximumAge(List<Person> people) {
        people.sort(Comparator.comparing(Person::getDateOfBirth));

        return people.get(0).getAge();
    }

    private Integer getMinimumAge(List<Person> people) {
        people.sort(Comparator.comparing(Person::getDateOfBirth).reversed());

        return people.get(0).getAge();
    }
}
