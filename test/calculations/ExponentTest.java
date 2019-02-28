package calculations;

import calculator.calculations.Calculations;
import calculator.calculations.Exponent;
import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class ExponentTest {
    @Test
    public void testExponent() {
        // Given
        Calculations testValue1 = new Value("3");
        Calculations testValue2 = new Value("2");
        // When
        Exponent testExponent = new Exponent(testValue1, testValue2);
        // Then
        float expectedResult = 9.0f;
        float actualResult = testExponent.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testExponent1() {
        // Given
        Calculations testValue1 = new Value(-3);
        Calculations testValue2 = new Value(2);
        // When
        Exponent testExponent = new Exponent(testValue1, testValue2);
        // Then
        float expectedResult = 9.0f;
        float actualResult = testExponent.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testExponent2() {
        // Given
        Calculations testValue1 = new Value(-3);
        Calculations testValue2 = new Value(-2);
        // When
        Exponent testExponent = new Exponent(testValue1, testValue2);
        // Then
        float expectedResult = 0.111111f;
        float actualResult = testExponent.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
