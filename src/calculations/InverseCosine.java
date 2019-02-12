package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.UnitsMode;

import static java.lang.Math.toRadians;

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
