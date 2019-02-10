package calculations;

import calculations.Calculations;
import calculations.Cosine;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class InverseCosineTest {
    @Test
    public void testInverseCosine() {
        // Given
        Calculations testValue1 = new Value(.75f);
        // When
        InverseCosine testInverseCosine = new InverseCosine(testValue1);
        // Then
        float expectedResult = .722734f;
        float actualResult = testInverseCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }
}