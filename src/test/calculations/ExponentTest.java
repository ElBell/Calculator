package calculations;

import calculations.Calculations;
import calculations.Divide;
import calculations.Exponent;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class ExponentTest {
    @Test
    public void testExponent() {
        // Given
        Calculations testValue1 = new Value(3);
        Calculations testValue2 = new Value(2);
        // When
        Exponent testExponent = new Exponent(testValue1, testValue2);
        // Then
        float expectedResult = 9.0f;
        float actualResult = testExponent.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
