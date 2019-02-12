package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.UnitsMode;

public class Tangent implements Calculations {
    Calculations left;
    public Tangent(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        UnitsMode mode = CalculatorOptions.getInstance().getUnitsMode();
        return (float) Math.tan(mode.convertFromMode(left.evaluate()));
    }
}
