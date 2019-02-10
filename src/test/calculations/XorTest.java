
package calculations;

import calculations.Calculations;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;


public class XorTest {



    @Test
    public void XorTest() {
        // Given
        Calculations testValue1 = new Value(2);;
        Calculations testValue2 = new Value(7);;
        float expected = 5;
        // When
        Xor testValue = new Xor(testValue1, testValue2);
        // Then
        float actualResult = testValue.evaluate();
        Assert.assertEquals(expected, actualResult, 0.0001);
    }
}