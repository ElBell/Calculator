package calculator.calculations;

public class InverseNaturalLogarithm implements Calculations{
    Calculations left;
    public InverseNaturalLogarithm(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        return (float) Math.pow(Math.E, left.evaluate());
    }
}
