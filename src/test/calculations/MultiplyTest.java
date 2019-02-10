package calculations;

import calculations.Calculations;
import calculations.Multiply;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class MultiplyTest {
    @Test
    public void testMultiply() {
        // Given
        Calculations testValue1 = new Value(4);
        Calculations testValue2 = new Value(3);
        // When
        Multiply testMultiply = new Multiply(testValue1, testValue2);
        // Then
        float expectedResult = 12.0f;
        float actualResult = testMultiply.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
