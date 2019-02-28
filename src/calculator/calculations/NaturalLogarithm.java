package calculator.calculations;

public class NaturalLogarithm implements Calculations{
    Calculations left;
    public NaturalLogarithm(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        float value = (float) Math.log(left.evaluate());
        return value;
    }
}
