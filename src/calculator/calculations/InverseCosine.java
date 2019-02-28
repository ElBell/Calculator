package calculator.calculations;

import calculator.calculatorOptions.CalculatorOptions;
import calculator.calculatorOptions.UnitsMode;

public class InverseCosine implements Calculations {
    Calculations left;
    public InverseCosine(Calculations left) {
        this.left = left;
    }
    public float evaluate(){
        UnitsMode mode = CalculatorOptions.getInstance().getUnitsMode();
        return (float) Math.acos(mode.convertFromMode(left.evaluate()));
    }
}
