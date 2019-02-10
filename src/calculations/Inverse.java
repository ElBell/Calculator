package calculations;

import calculations.Calculations;

// should be flipped sign not invserse
public class InverseNumber implements Calculations {
    Calculations left;

    public InverseNumber(Calculations left){
         this.left = left;
    };

    public float evaluate() {
        {
            return 1 / left.evaluate();


        }
    }

}