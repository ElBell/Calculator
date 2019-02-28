package calculations;

import calculator.calculations.Calculations;
import calculator.calculations.Tangent;
import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class TangentTest {
    @Test
    public void testTangent() {
        // Given
        Calculations testValue1 = new Value(8);
        // When
        Tangent testTangent = new Tangent(testValue1);
        // Then
        float expectedResult = -6.79971f;
        float actualResult = testTangent.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
}
