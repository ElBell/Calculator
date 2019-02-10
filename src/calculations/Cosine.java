package calculations;

public class Cosine implements Calculations{
    Calculations left;
    public Cosine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {return (float) Math.cos(left.evaluate());
    }
}
