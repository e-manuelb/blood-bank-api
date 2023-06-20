package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.domain.features.*;
import br.com.ecb.bloodbankapi.domain.features.person.ListPersons;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetProcessedInformationService implements GetProcessedInformation {
    private final ListPersons listPersonsService;
    private final GetPersonQuantityForEachState getPersonQuantityForEachStateService;
    private final GetAvailableDonorsForEachBloodType getAvailableDonorsForEachBloodTypeService;
    private final GetAverageAgeForEachBloodType getAverageAgeForEachBloodTypeService;
    private final GetAverageBMIPerAge getAverageBMIPerAgeService;
    private final GetPercentageOfObeseMenAndWomen getPercentageOfObeseMenAndWomen;

    public GetProcessedInformationService(
            ListPersons listPersonsService,
            GetPersonQuantityForEachState getPersonQuantityForEachStateService,
            GetAvailableDonorsForEachBloodType getAvailableDonorsForEachBloodTypeService,
            GetAverageAgeForEachBloodType getAverageAgeForEachBloodTypeService,
            GetAverageBMIPerAge getAverageBMIPerAgeService,
            GetPercentageOfObeseMenAndWomen getPercentageOfObeseMenAndWomen
    ) {
        this.listPersonsService = listPersonsService;
        this.getPersonQuantityForEachStateService = getPersonQuantityForEachStateService;
        this.getAvailableDonorsForEachBloodTypeService = getAvailableDonorsForEachBloodTypeService;
        this.getAverageAgeForEachBloodTypeService = getAverageAgeForEachBloodTypeService;
        this.getAverageBMIPerAgeService = getAverageBMIPerAgeService;
        this.getPercentageOfObeseMenAndWomen = getPercentageOfObeseMenAndWomen;
    }

    public Map<String, Object> handle() {
        Map<String, Object> result = new HashMap<>();

        List<Person> people = listPersonsService.handle();

        if (people.size() == 0) {
            result.put("message", "People not found. Please register someone.");
        } else {
            result.put("personQuantityForEachState", getPersonQuantityForEachStateService.handle());
            result.put("averageBMIPerAge", getAverageBMIPerAgeService.handle(people));
            result.put("percentageOfObeseMenAndWomen", getPercentageOfObeseMenAndWomen.handle(people));
            result.put("averageAgeForEachBloodType", getAverageAgeForEachBloodTypeService.handle(people));
            result.put("availableDonorsForEachBloodType", getAvailableDonorsForEachBloodTypeService.handle(people));
        }

        return result;
    }
}
