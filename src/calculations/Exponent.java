public class Exponent implements Calculations {
    Calculations left;
    Calculations right;
    public Exponent(Calculations left, Calculations right) {
        this.left = left;
        this.right = right;
    }
    public float evaluate() {
        double tempDouble = Math.pow(left.evaluate(), right.evaluate());
        float value = (float)tempDouble;

        return value;
    }
}
