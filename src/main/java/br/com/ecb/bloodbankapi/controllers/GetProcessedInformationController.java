package br.com.ecb.bloodbankapi.controllers;

import br.com.ecb.bloodbankapi.domain.features.GetProcessedInformation;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class GetProcessedInformationController {
    private final GetProcessedInformation getProcessedInformationService;

    public GetProcessedInformationController(GetProcessedInformation getProcessedInformationService) {
        this.getProcessedInformationService = getProcessedInformationService;
    }

    public Map<String, Object> handle() {
        return getProcessedInformationService.handle();
    }
}
