package calculations;

import calculations.Calculations;

public class SwitchSign implements Calculations {
    Calculations left;
    public SwitchSign(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        float value = left.evaluate() * -1;
        return value;
    }

}
