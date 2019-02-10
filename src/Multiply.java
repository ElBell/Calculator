public class Multiply implements Calculations{
    Calculations left;
    Calculations right;
    public Multiply(Calculations left, Calculations right) {
        this.left = left;
        this.right = right;
    }
    public float evaluate() {
        float value = left.evaluate() * right.evaluate();
        return value;
    }
}
