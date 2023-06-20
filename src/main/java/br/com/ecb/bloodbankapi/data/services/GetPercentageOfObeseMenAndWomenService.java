package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.domain.features.GetBMI;
import br.com.ecb.bloodbankapi.domain.features.GetPercentageOfObeseMenAndWomen;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetPercentageOfObeseMenAndWomenService implements GetPercentageOfObeseMenAndWomen {
    private final GetBMI getBMIService;

    public GetPercentageOfObeseMenAndWomenService(GetBMI getBMIService) {
        this.getBMIService = getBMIService;
    }

    public Map<String, Double> handle(List<Person> people) {
        List<Double> maleBMIList = new ArrayList<>();
        List<Double> femaleBMIList = new ArrayList<>();

        people.forEach(person -> {
            if (Objects.equals(person.getInfo().getGender(), "Masculino")) {
                maleBMIList.add(getBMIService.handle(person.getInfo().getHeight(), person.getInfo().getWeight()));
            }

            if (Objects.equals(person.getInfo().getGender(), "Feminino")) {
                femaleBMIList.add(getBMIService.handle(person.getInfo().getHeight(), person.getInfo().getWeight()));
            }
        });

        Integer obeseMenQuantity = maleBMIList.stream().filter(bmi -> bmi > 30).toList().size();
        Integer obeseWomenQuantity = femaleBMIList.stream().filter(bmi -> bmi > 30).toList().size();

        Map<String, Double> percentages = new HashMap<>();

        percentages.put("male", ((double) (obeseMenQuantity * 100) / maleBMIList.size()));
        percentages.put("female", ((double) (obeseWomenQuantity * 100) / femaleBMIList.size()));

        return percentages;
    }
}
