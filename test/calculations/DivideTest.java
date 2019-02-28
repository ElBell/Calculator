package calculations;

import calculator.calculations.Calculations;
import calculator.calculations.Divide;
import calculator.calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class DivideTest {
    @Test
    public void testDivide() {
        // Given
        Calculations testValue1 = new Value("9");
        Calculations testValue2 = new Value("3");
        // When
        Divide testDivide = new Divide(testValue1, testValue2);
        // Then
        float expectedResult = 3.0f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testDivide1() {
        // Given
        Calculations testValue1 = new Value(-6);
        Calculations testValue2 = new Value(2);
        // When
        Divide testDivide = new Divide(testValue1, testValue2);
        // Then
        float expectedResult = -3.0f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testDivide2() {
        // Given
        Calculations testValue1 = new Value(-5);
        Calculations testValue2 = new Value(-2);
        // When
        Divide testDivide = new Divide(testValue1, testValue2);
        // Then
        float expectedResult = 2.5f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}

