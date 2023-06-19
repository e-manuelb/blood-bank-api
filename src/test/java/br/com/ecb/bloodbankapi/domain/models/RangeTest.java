package br.com.ecb.bloodbankapi.domain.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RangeTest {

    @Test
    public void testAllArgsConstructorSuccessfully() {
        Integer start = 10;
        Integer end = 30;

        Range range = new Range(start, end);

        Assertions.assertNotNull(range);
        Assertions.assertEquals(start, range.getStart());
        Assertions.assertEquals(end, range.getEnd());
    }

    @Test
    public void testNoArgsConstructorSuccessfully() {
        Range range = new Range();

        Assertions.assertNotNull(range);
    }

    @Test
    public void testRangeCreatedSuccessfully() {
        Integer start = 10;
        Integer end = 30;

        Range range = new Range().setStart(start).setEnd(end);

        Assertions.assertNotNull(range);
        Assertions.assertEquals(start, range.getStart());
        Assertions.assertEquals(end, range.getEnd());
    }

    @Test
    public void testToStringSuccessfully() {
        Integer start = 10;
        Integer end = 30;

        Range range = new Range().setStart(start).setEnd(end);

        Assertions.assertNotNull(range.toString());
        Assertions.assertEquals(start, range.getStart());
        Assertions.assertEquals(end, range.getEnd());
    }
}
