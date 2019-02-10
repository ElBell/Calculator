package calculations;

public class InverseNaturalLogarithm implements Calculations{
    Calculations left;
    public InverseNaturalLogarithm(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        float value = (float) Math.pow(Math.E, Math.log(left.evaluate()));
        return value;
    }
}
