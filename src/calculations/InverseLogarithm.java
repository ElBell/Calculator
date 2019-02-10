package calculations;

public class InverseLogarithm implements Calculations {
    Calculations left;
    public InverseLogarithm(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        return (float) Math.pow(10, left.evaluate());
    }
}
