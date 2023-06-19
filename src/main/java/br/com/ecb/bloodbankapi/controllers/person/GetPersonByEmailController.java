package br.com.ecb.bloodbankapi.controllers.person;

import br.com.ecb.bloodbankapi.domain.features.person.GetPersonByEmail;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Controller;

@Controller
public class GetPersonByEmailController {
    private final GetPersonByEmail getPersonByEmailService;

    public GetPersonByEmailController(GetPersonByEmail getPersonByEmailService) {
        this.getPersonByEmailService = getPersonByEmailService;
    }

    public Person handle(String email) {
        return getPersonByEmailService.handle(email);
    }
}
