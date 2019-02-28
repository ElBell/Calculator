package calculator.calculations;

public class Exponent implements Calculations {
    Calculations left;
    Calculations right;
    public Exponent(Calculations left, Calculations right) {
        this.left = left;
        this.right = right;
    }
    public float evaluate() {
        return (float) Math.pow(left.evaluate(), right.evaluate());
    }
}
