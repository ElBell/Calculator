package calculations;

public class Sine implements Calculations {
    Calculations left;
    public Sine(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        return (float) Math.sin(left.evaluate());
    }

    public static class Tangent implements Calculations{
        Calculations left;
        public Tangent(Calculations left) {
            this.left = left;
        }
        public float evaluate() {
            return (float) Math.tan(left.evaluate());
        }
    }
}