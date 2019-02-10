import calculations.Add;
import calculations.Calculations;
import calculations.Value;
import org.junit.Test;

public class AddTest {
    @Test
    public void trialTest() {
        Calculations testValue1 = new Value(5);
        Calculations testValue2 = new Value(3);
        Add addTest = new Add(testValue1, testValue2);
        float result = addTest.evaluate();
        System.out.println(result);
    }
}
