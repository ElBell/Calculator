import calculations.Calculations;
import calculations.Exponent;
import calculations.Value;
import org.junit.Assert;
import org.junit.Test;

public class ExponentTest {
    @Test
    public void trialTest() {
        Calculations testValue1 = new Value(5);
        Calculations testValue2 = new Value(3);
        Exponent addTest = new Exponent(testValue1, testValue2);
        float result = addTest.evaluate();
        Assert.assertEquals(125.0f, result, .001);
    }

}
