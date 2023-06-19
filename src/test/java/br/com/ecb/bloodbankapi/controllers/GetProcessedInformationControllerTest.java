package br.com.ecb.bloodbankapi.controllers;

import br.com.ecb.bloodbankapi.domain.features.GetProcessedInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class GetProcessedInformationControllerTest {
    private GetProcessedInformation getProcessedInformationService;
    private GetProcessedInformationController getProcessedInformationController;

    @BeforeEach
    public void init() {
        getProcessedInformationService = Mockito.mock(GetProcessedInformation.class);
        getProcessedInformationController = new GetProcessedInformationController(getProcessedInformationService);
    }

    @Test
    public void testProcessesInformationControllerSuccessfully() {
        Map<String, Object> expectedResponse = new HashMap<>();

        Mockito.when(getProcessedInformationService.handle()).thenReturn(expectedResponse);

        Map<String, Object> response = getProcessedInformationController.handle();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(expectedResponse, response);
    }
}
