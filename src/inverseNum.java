
// should be flipped sign not invserse
public class inverseNum implements Calculations {
    Calculations left;

    public inverseNum(Calculations left){
         this.left = left;
    };

    public float evaluate() {
        {
            return left.evaluate() * (-1);


        }
    }

}