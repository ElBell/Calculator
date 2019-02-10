package calculations;

import static java.lang.Math.toRadians;

public class InverseTangent implements Calculations {
    Calculations left;
    public InverseTangent(Calculations left) {

        this.left = left;
    }
    public float evaluate() {
        return (float) Math.atan(left.evaluate());
    }
}
