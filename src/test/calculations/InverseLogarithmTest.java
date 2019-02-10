package calculations;

import org.junit.Assert;
import org.junit.Test;

public class InverseLogarithmTest {
    @Test
    public void testInverseLogarithm() {
        // Given
        Calculations testValue1 = new Value("9");
        // When
        InverseLogarithm testInverseLogarithmTest = new InverseLogarithm(testValue1);
        // Then
        float expectedResult = 1000000000;
        float actualResult = testInverseLogarithmTest.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.1);
    }
}
