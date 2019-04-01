package calculator.calculations;

public class Divide implements Calculations{
    Calculations left;
    Calculations right;
    public Divide(Calculations left, Calculations right) {
        this.left = left;
        this.right = right;
    }
    public float evaluate() {
       return left.evaluate() / right.evaluate();
    }
}
