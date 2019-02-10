package calculations;

import calculations.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


@SuppressWarnings("all")
public class MathTest {
    Calculations small = new Value(3);
    Calculations med = new Value(9);

    Square square = new Square(small);
    SquareRoot squareRoot = new SquareRoot(med);

    @Test
    public void testSquare(){
        // : Given
        float given = 3;
        float expected = 9;

        // : When
        float actual = square.evaluate();
        // : Then

        assertEquals( expected, actual, 0.02);
    }

    @Test
    public void testSqrtRt(){
        // : Given
        float given = 9;
        float expected = 3;

        // : When
        float actual = squareRoot.evaluate();
        // : Then

        assertEquals( expected, actual, 0.02);
    }

}
