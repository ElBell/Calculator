package calculations;

import calculations.Add;
import calculations.Calculations;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    @Test
    public void testAdd() {
        // Given
        Calculations testValue1 = new Value("5");
        Calculations testValue2 = new Value("3");
        // When
        Add testDivide = new Add(testValue1, testValue2);
        // Then
        float expectedResult = 8.0f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testAdd1() {
        // Given
        Calculations testValue1 = new Value(-5);
        Calculations testValue2 = new Value(3);
        // When
        Add testDivide = new Add(testValue1, testValue2);
        // Then
        float expectedResult = -2.0f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testAdd2() {
        // Given
        Calculations testValue1 = new Value(-5);
        Calculations testValue2 = new Value(-3);
        // When
        Add testDivide = new Add(testValue1, testValue2);
        // Then
        float expectedResult = -8.0f;
        float actualResult = testDivide.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
