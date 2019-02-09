
public class SqrtRoot implements Calculations {
    Calculations left;

    public SqrtRoot(Calculations left) {

        this.left = left;
};

    public float evaluate() {

        return (float)Math.sqrt(left.evaluate());

    }

}

