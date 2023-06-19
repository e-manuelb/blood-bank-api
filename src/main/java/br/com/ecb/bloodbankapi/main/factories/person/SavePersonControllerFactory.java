package br.com.ecb.bloodbankapi.main.factories.person;

import br.com.ecb.bloodbankapi.controllers.person.SavePersonController;
import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;

public class SavePersonControllerFactory {
    private final SavePerson savePersonService;

    public SavePersonControllerFactory(SavePerson savePersonService) {
        this.savePersonService = savePersonService;
    }

    public SavePersonController makeSavePersonController() {
        return new SavePersonController(savePersonService);
    }
}
