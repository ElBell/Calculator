package calculations;

import calculations.Add;
import calculations.Calculations;
import calculations.Divide;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class DivideTest {
    @Test
    public void testDivide() {
        // Given
        Calculations testValue1 = new Value(9);
        Calculations testValue2 = new Value(3);
        // When
        Divide testDivide = new Divide(testValue1, testValue2);
        // Then
        float expectedResult = 3.0f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
