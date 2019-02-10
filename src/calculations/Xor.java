package calculations;

public class Xor implements Calculations {
        Calculations left;
        Calculations right;

        public Xor(Calculations left, Calculations right) {
         this.left = left;
         this.right = right;

        }

    public float evaluate() {
        float initVal = left.evaluate();
        float converterVal = right.evaluate();

        int hold;

         hold = (int)initVal^(int)converterVal;

        return (float)hold;
    }
}

