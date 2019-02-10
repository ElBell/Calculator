package calculations;

import static java.lang.Math.toRadians;

public class InverseSine implements Calculations {
    Calculations left;
    public InverseSine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        return (float) Math.asin(left.evaluate());
    }
}
