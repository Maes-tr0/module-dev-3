package ua.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    public void beforeEach(){
        sumCalculator = new SumCalculator();
    }

    @Test
    public void testSumIsCorrectResultWithZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(0));
    }

    @Test
    public void testSumIsCorrectResultWithOne(){
        int actual = sumCalculator.sum(1);

        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumIsCorrectResultWithNegativeNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(-10));
    }

    @Test
    public void testSumIsCorrectResultWithBigNumber(){
        int actual = sumCalculator.sum(65535);

        int expected = 2_147_450_880;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumIsCorrectResultWithNumber(){
        int actual = sumCalculator.sum(5);

        int expected = 15;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSumOverflow() {
        int number = 65536;

        try {
            long actual = sumCalculator.sum(number);
            long expected = (long) number * (number + 1) / 2;
            Assertions.assertEquals(expected, actual, "Значення суми не співпадає з очікуваним");
        } catch (ArithmeticException ex) {
            Assertions.fail("Значення суми перевищує тип int");
        }
    }

}
