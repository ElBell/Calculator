package calculations;

import static java.lang.Math.toRadians;

public class InverseCosine implements Calculations {
    Calculations left;
    public InverseCosine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        return (float) toRadians(Math.acos(left.evaluate()));
    }
}
