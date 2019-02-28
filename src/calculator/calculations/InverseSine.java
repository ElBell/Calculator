package calculator.calculations;

import calculator.calculatorOptions.CalculatorOptions;
import calculator.calculatorOptions.UnitsMode;

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
