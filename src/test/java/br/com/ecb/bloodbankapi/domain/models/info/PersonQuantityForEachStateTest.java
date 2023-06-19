package br.com.ecb.bloodbankapi.domain.models.info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonQuantityForEachStateTest {

    @Test
    public void testAllArgsConstructorSuccessfully() {
        String state = "CE";
        Long quantity = (long) 8000000;

        PersonQuantityForEachState personQuantityForEachState = new PersonQuantityForEachState(state, quantity);

        Assertions.assertNotNull(personQuantityForEachState);
        Assertions.assertEquals(personQuantityForEachState.getState(), state);
        Assertions.assertEquals(personQuantityForEachState.getQuantity(), quantity);
    }

    @Test
    public void testNoArgsConstructorSuccessfully() {
        PersonQuantityForEachState personQuantityForEachState = new PersonQuantityForEachState();

        Assertions.assertNotNull(personQuantityForEachState);
    }

    @Test
    public void testPersonQuantityForEachStateCreatedSuccessfully() {
        String state = "CE";
        Long quantity = (long) 8000000;

        PersonQuantityForEachState personQuantityForEachState =
                new PersonQuantityForEachState().setState(state).setQuantity(quantity);

        Assertions.assertNotNull(personQuantityForEachState);
        Assertions.assertEquals(personQuantityForEachState.getState(), state);
        Assertions.assertEquals(personQuantityForEachState.getQuantity(), quantity);
    }
}
