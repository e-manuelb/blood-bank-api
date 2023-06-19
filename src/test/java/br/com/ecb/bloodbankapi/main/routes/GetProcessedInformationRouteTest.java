package br.com.ecb.bloodbankapi.main.routes;

import br.com.ecb.bloodbankapi.controllers.GetProcessedInformationController;
import br.com.ecb.bloodbankapi.domain.features.GetProcessedInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class GetProcessedInformationRouteTest {
    private GetProcessedInformation getProcessedInformationService;
    private GetProcessedInformationController getProcessedInformationController;
    private GetProcessedInformationRoute getProcessedInformationRoute;

    @BeforeEach
    public void init() {
        getProcessedInformationService = Mockito.mock(GetProcessedInformation.class);
        getProcessedInformationController = Mockito.mock(GetProcessedInformationController.class);

        getProcessedInformationRoute = new GetProcessedInformationRoute(getProcessedInformationService);
    }

    @Test
    public void testGetProcessedInformationTest() {
        Map<String, Object> expectedResponse = new HashMap<>();

        Mockito.when(getProcessedInformationController.handle()).thenReturn(expectedResponse);

        Map<String, Object> response = getProcessedInformationRoute.handle();

        Assertions.assertNotNull(response);
    }
}
