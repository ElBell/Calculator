package calculations;

import org.junit.Assert;
import org.junit.Test;

public class InverseNaturalLogarithmTest {
    @Test
    public void testInverseNaturalLogarithm() {
        // Given
        Calculations testValue1 = new Value(9);
        // When
        InverseNaturalLogarithm testInverseNaturalLogarithmTest = new InverseNaturalLogarithm(testValue1);
        // Then
        float expectedResult = 8103.0839f;
        float actualResult = testInverseNaturalLogarithmTest.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.1);
    }

}
