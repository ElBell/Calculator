package calculations;

import calculations.Calculations;
import calculations.InverseTangent;
import calculations.Subtract;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class InverseTangentTest {
    @Test
    public void testInverseTangent() {
        // Given
        Calculations testValue1 = new Value("45");
        // When
        InverseTangent testInverseTangent = new InverseTangent(testValue1);
        // Then
        float expectedResult = 1.5485f;
        float actualResult = testInverseTangent.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.01);
    }
}
