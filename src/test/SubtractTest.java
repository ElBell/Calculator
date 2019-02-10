import calculations.Calculations;
import calculations.Subtract;
import calculations.Value;
import org.junit.Test;

public class SubtractTest {
    @Test
    public void trialTest() {
        Calculations testValue1 = new Value(5);
        Calculations testValue2 = new Value(3);
        Subtract subtractTest = new Subtract(testValue1, testValue2);
        float result = subtractTest.evaluate();
        System.out.println(result);
    }
}
