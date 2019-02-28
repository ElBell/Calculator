package calculations;

import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class ValueTest {
    @Test
    public void testValue() {
        // Given
        String testValue1 = "9.0f";
        // When
        Value testValue = new Value(testValue1);
        // Then
        float actualResult = testValue.evaluate();
        Assert.assertEquals(9.0f, actualResult, 0.0001);
    }
}
