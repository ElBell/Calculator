package calculations;

import calculator.calculations.Add;
import calculator.calculations.Calculations;
import calculator.calculations.Value;
import calculator.calculatorOptions.CalculatorOptions;
import calculator.calculatorOptions.DisplayMode;
import org.junit.Assert;
import org.junit.Test;

public class AddTest {
    @Test
    public void testAdd() {
        // Given
        Calculations testValue1 = new Value("5");
        Calculations testValue2 = new Value("3");
        // When
        Add testAdd = new Add(testValue1, testValue2);
        // Then
        float expectedResult = 8.0f;
        float actualResult = testAdd.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testAdd1() {
        // Given
        Calculations testValue1 = new Value(-5);
        Calculations testValue2 = new Value(3);
        // When
        Add testAdd1 = new Add(testValue1, testValue2);
        // Then
        float expectedResult = -2.0f;
        float actualResult = testAdd1.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testAdd2() {
        // Given
        Calculations testValue1 = new Value(-5);
        Calculations testValue2 = new Value(-3);
        // When
        Add testAdd2 = new Add(testValue1, testValue2);
        // Then
        float expectedResult = -8.0f;
        float actualResult = testAdd2.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }

    @Test
    public void testAddBinary() {
        // Given
        CalculatorOptions mode = CalculatorOptions.getInstance();
        mode.setDisplayMode(DisplayMode.BINARY);
        Calculations testValue1 = new Value("1");
        Calculations testValue2 = new Value("10");
        // When
        Add testAddBinary = new Add(testValue1, testValue2);
        // Then
        float expectedResult = 3f;
        float actualResult = testAddBinary.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
        mode.setDisplayMode(DisplayMode.DECIMAL);
    }
}
