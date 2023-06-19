package br.com.ecb.bloodbankapi.main.config.beans;

import br.com.ecb.bloodbankapi.data.services.GetProcessedInformationService;
import br.com.ecb.bloodbankapi.domain.features.*;
import br.com.ecb.bloodbankapi.domain.features.person.ListPersons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetProcessedInformationBean {
    private final ListPersons listPersonsService;
    private final GetPersonQuantityForEachState getPersonQuantityForEachStateService;
    private final GetAvailableDonorsForEachBloodType getAvailableDonorsForEachBloodTypeService;
    private final GetAverageAgeForEachBloodType getAverageAgeForEachBloodTypeService;
    private final GetAverageBMIPerAge getAverageBMIPerAgeService;
    private final GetPercentageOfObeseMenAndWomen getPercentageOfObeseMenAndWomen;

    public GetProcessedInformationBean(
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

    @Bean
    GetProcessedInformation getProcessedInformation() {
        return new GetProcessedInformationService(
                listPersonsService,
                getPersonQuantityForEachStateService,
                getAvailableDonorsForEachBloodTypeService,
                getAverageAgeForEachBloodTypeService,
                getAverageBMIPerAgeService,
                getPercentageOfObeseMenAndWomen
        );
    }
}
