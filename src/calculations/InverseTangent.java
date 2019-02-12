package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.UnitsMode;

import static java.lang.Math.toRadians;

public class InverseTangent implements Calculations {
    Calculations left;
    public InverseTangent(Calculations left) {

        this.left = left;
    }
    public float evaluate() {
        UnitsMode mode = CalculatorOptions.getInstance().getUnitsMode();
        return (float) Math.atan(mode.convertFromMode(left.evaluate()));
    }
}
