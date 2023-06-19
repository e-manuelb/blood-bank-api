package br.com.ecb.bloodbankapi.main.factories.person;

import br.com.ecb.bloodbankapi.controllers.person.GetPersonByEmailController;
import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;

public class GetPersonByEmailControllerFactory {
    private final GetPersonByEmail getPersonByEmailService;

    public GetPersonByEmailControllerFactory(GetPersonByEmail getPersonByEmailService) {
        this.getPersonByEmailService = getPersonByEmailService;
    }

    public GetPersonByEmailController makeGetPersonByEmailController() {
        return new GetPersonByEmailController(getPersonByEmailService);
    }
}
