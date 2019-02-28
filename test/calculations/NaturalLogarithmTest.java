package calculations;

import calculator.calculations.Calculations;
import calculator.calculations.NaturalLogarithm;
import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class NaturalLogarithmTest {
    @Test
    public void testNaturalLogarithm() {
        // Given
        Calculations testValue1 = new Value("8");
        // When
        NaturalLogarithm testNaturalLogarithm = new NaturalLogarithm(testValue1);
        // Then
        float expectedResult = 2.079441f;
        float actualResult = testNaturalLogarithm.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
}
