package calculations;

import calculations.Calculations;
import calculations.Cosine;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class CosineTest {
    @Test
    public void testCosine() {
        // Given
        Calculations testValue1 = new Value("9");
        // When
        Cosine testCosine = new Cosine(testValue1);
        // Then
        float expectedResult = 0.987688f;
        float actualResult = testCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCosine1() {
        // Given
        Calculations testValue1 = new Value(10);
        // When
        Cosine testCosine = new Cosine(testValue1);
        // Then
        float expectedResult = 0.984807f;
        float actualResult = testCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }

    @Test
    public void testCosine2() {
        // Given
        Calculations testValue1 = new Value(95);
        // When
        Cosine testCosine = new Cosine(testValue1);
        // Then
        float expectedResult = -0.087155f;
        float actualResult = testCosine.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.001);
    }
}
