package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.UnitsMode;

public class Sine implements Calculations {
    Calculations left;
    public Sine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        UnitsMode mode = CalculatorOptions.getInstance().getUnitsMode();
        return (float) Math.sin(mode.convertFromMode(left.evaluate()));
    }

}