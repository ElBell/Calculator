import calculations.Calculations;
import calculations.Multiply;
import calculations.Value;
import org.junit.Test;

public class MultiplyTest {
    @Test
    public void multTest() {
        Calculations testValue3 = new Value(6);
        Calculations testValue4 = new Value(12);
        Multiply xTest = new Multiply(testValue3, testValue4);
        float result2 = xTest.evaluate();
        System.out.println(result2);

    }
}
