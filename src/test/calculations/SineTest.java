package calculations;

import org.junit.Assert;
import org.junit.Test;

public class SineTest {
    @Test
    public void testSineTest() {
        // Given
        Calculations testValue1 = new Value(8);
        // When
        Sine testSine = new Sine(testValue1);
        // Then
        float expectedResult = 0.9893582f;
        float actualResult = testSine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
}
