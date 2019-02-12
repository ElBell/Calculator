package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.UnitsMode;

import static java.lang.Math.toRadians;

public class InverseSine implements Calculations {
    Calculations left;
    public InverseSine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        UnitsMode mode = CalculatorOptions.getInstance().getUnitsMode();
        return (float) Math.asin(mode.convertFromMode(left.evaluate()));
    }
}
