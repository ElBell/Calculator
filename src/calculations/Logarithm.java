package calculations;

public class Logarithm implements Calculations{
    Calculations left;
    public Logarithm(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        float value = (float) Math.log10(left.evaluate());
        return value;
    }
}
