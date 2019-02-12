package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.UnitsMode;

public class Cosine implements Calculations{
    Calculations left;
    public Cosine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        UnitsMode mode = CalculatorOptions.getInstance().getUnitsMode();
        return (float) Math.cos(mode.convertFromMode(left.evaluate()));
    }
}
