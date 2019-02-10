package calculations;

import calculations.Calculations;

public class SquareRoot implements Calculations {
    Calculations left;

    public SquareRoot(Calculations left) {

        this.left = left;
};

    public float evaluate() {

        return (float)Math.sqrt(left.evaluate());

    }

}

