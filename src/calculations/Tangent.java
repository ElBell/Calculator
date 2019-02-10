package calculations;

public class Tangent implements Calculations {
    Calculations left;
    public Tangent(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        float value = (float) Math.tan(left.evaluate());
        return value;
    }
}
