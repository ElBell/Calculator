import calculations.Calculations;
import calculations.Divide;
import calculations.Value;
import org.junit.Test;

public class DivideTest {
    @Test
    public void trialTest() {
        Calculations testValue1 = new Value(6);
        Calculations testValue2 = new Value(3);
        Divide addTest = new Divide(testValue1, testValue2);
        float result = addTest.evaluate();
        System.out.println(result);
    }
}
