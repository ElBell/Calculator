import calculations.Calculations;
import calculations.Subtract;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class SubtractTest {
    @Test
    public void testSubtract() {
        // Given
        Calculations testValue1 = new Value(9);
        Calculations testValue2 = new Value(3);
        // When
        Subtract testSubtract = new Subtract(testValue1, testValue2);
        // Then
        float expectedResult = 6.0f;
        float actualResult = testSubtract.evaluate();
        Assert.assertEquals(expectedResult, actualResult, 0.0001);
    }
}
