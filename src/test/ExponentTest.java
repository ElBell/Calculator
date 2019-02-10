import org.junit.Test;

public class ExponentTest {
    @Test
    public void trialTest() {
        Calculations testValue1 = new Value(5);
        Calculations testValue2 = new Value(3);
        Exponent addTest = new Exponent(testValue1, testValue2);
        float result = addTest.evaluate();
        System.out.println(result);
    }
}
