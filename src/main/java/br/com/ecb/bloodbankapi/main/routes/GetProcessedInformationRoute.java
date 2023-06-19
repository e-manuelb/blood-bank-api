package br.com.ecb.bloodbankapi.main.routes;

import br.com.ecb.bloodbankapi.controllers.GetProcessedInformationController;
import br.com.ecb.bloodbankapi.domain.features.GetProcessedInformation;
import br.com.ecb.bloodbankapi.main.factories.GetProcessedInformationControllerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/info")
public class GetProcessedInformationRoute {
    private final GetProcessedInformation getProcessedInformationService;

    public GetProcessedInformationRoute(GetProcessedInformation getProcessedInformationService) {
        this.getProcessedInformationService = getProcessedInformationService;
    }

    @GetMapping("/")
    public Map<String, Object> handle() {
        GetProcessedInformationController getProcessedInformationController = new GetProcessedInformationControllerFactory(getProcessedInformationService).makeGetProcessedInformationController();

        return getProcessedInformationController.handle();
    }
}
