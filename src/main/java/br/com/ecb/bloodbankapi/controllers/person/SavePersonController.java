package br.com.ecb.bloodbankapi.controllers.person;

import br.com.ecb.bloodbankapi.domain.features.person.SavePerson;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Controller;

@Controller
public class SavePersonController {
    private final SavePerson savePersonService;

    public SavePersonController(SavePerson savePersonService) {
        this.savePersonService = savePersonService;
    }

    public Person handle(Person person) {
        return savePersonService.handle(person);
    }
}
