package calculations;

import calculator.calculations.Calculations;
import calculator.calculations.Logarithm;
import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class LogarithmTest {
    @Test
    public void testLogarithm() {
        // Given
        Calculations testValue1 = new Value("8");
        // When
        Logarithm testLogarithm = new Logarithm(testValue1);
        // Then
        float expectedResult = 0.903089f;
        float actualResult = testLogarithm.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
}
