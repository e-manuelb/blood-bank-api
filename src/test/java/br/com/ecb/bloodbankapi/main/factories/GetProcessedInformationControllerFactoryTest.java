package br.com.ecb.bloodbankapi.main.factories;

import br.com.ecb.bloodbankapi.controllers.GetProcessedInformationController;
import br.com.ecb.bloodbankapi.domain.features.GetProcessedInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GetProcessedInformationControllerFactoryTest {
    private GetProcessedInformation getProcessedInformationService;

    private GetProcessedInformationControllerFactory getProcessedInformationControllerFactory;

    @BeforeEach
    void init() {
        getProcessedInformationService = Mockito.mock(GetProcessedInformation.class);
        getProcessedInformationControllerFactory = new GetProcessedInformationControllerFactory(getProcessedInformationService);
    }

    @Test
    public void testMakeGetProcessedInformationControllerFactorySuccessfully() {
        GetProcessedInformationController getProcessedInformationController = getProcessedInformationControllerFactory.makeGetProcessedInformationController();

        Assertions.assertNotNull(getProcessedInformationController);
    }
}
