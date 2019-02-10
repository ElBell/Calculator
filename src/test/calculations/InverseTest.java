package calculations;

import calculations.Calculations;
import calculations.Inverse;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class InverseTest {
    @Test
    public void testInverse() {
        // Given
        Calculations testValue1 = new Value(10);
        // When
        Inverse testInverse = new Inverse(testValue1);
        // Then
        float expectedResult = 0.1f;
        float actualResult = testInverse.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
