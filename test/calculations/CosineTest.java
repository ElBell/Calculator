package calculations;

import calculator.calculations.Calculations;
import calculator.calculations.Cosine;
import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class CosineTest {
    @Test
    public void testCosine() {
        // Given
        Calculations testValue1 = new Value(0);
        // When
        Cosine testCosine = new Cosine(testValue1);
        // Then
        float expectedResult = 1f;
        float actualResult = testCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCosine1() {
        // Given
        Calculations testValue1 = new Value((float)(Math.PI/2));
        // When
        Cosine testCosine = new Cosine(testValue1);
        // Then
        float expectedResult = 0f;
        float actualResult = testCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCosine2() {
        // Given
        Calculations testValue1 = new Value((float)(Math.PI/3));
        // When
        Cosine testCosine = new Cosine(testValue1);
        // Then
        float expectedResult = 0.5f;
        float actualResult = testCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }
}
