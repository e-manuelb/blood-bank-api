package br.com.ecb.bloodbankapi.main.factories;

import br.com.ecb.bloodbankapi.controllers.GetProcessedInformationController;
import br.com.ecb.bloodbankapi.domain.features.GetProcessedInformation;

public class GetProcessedInformationControllerFactory {
    private final GetProcessedInformation getProcessedInformationService;

    public GetProcessedInformationControllerFactory(GetProcessedInformation getProcessedInformationService) {
        this.getProcessedInformationService = getProcessedInformationService;
    }

    public GetProcessedInformationController makeGetProcessedInformationController() {
        return new GetProcessedInformationController(getProcessedInformationService);
    }
}
