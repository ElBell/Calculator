package calculations;

import calculations.Calculations;

public class Divide implements Calculations{
    Calculations left;
    Calculations right;
    public Divide(Calculations left, Calculations right) {
        this.left = left;
        this.right = right;
    }
    public float evaluate() {
        float value =0;
        try {
            value = left.evaluate() / right.evaluate();
        }
        catch (Exception e) {
            System.err.print("Error");
        } finally {
            return value;
        }
            //return value;



    }
}
