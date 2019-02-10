package calculations;

import calculations.Calculations;

// should be flipped sign not invserse
public class Inverse implements Calculations {
    Calculations left;

    public Inverse(Calculations left){
         this.left = left;
    };

    public float evaluate() {
        {
            return 1 / left.evaluate();


        }
    }

}