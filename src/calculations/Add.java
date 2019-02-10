package calculations;

import calculations.Calculations;

public class Add implements Calculations{
    Calculations left;
    Calculations right;
    public Add(Calculations left, Calculations right) {
        this.left = left;
        this.right = right;
    }
    public float evaluate() {
        float value = left.evaluate() + right.evaluate();
        return value;
    }

}
