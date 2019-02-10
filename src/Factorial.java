
public class Factorial implements Calculations{
    Calculations left;
    public Factorial(Calculations left) {
        this.left = left;
    }
    public float evaluate() {
        float f = left.evaluate();
                for (int i = 1; i <= left.evaluate(); i++) {
                    f *= i;
                }
                return f;
            }
        }