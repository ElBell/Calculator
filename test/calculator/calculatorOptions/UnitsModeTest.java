package calculator.calculatorOptions;

import calculator.calculations.Calculations;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitsModeTest {

    @Test
    public void convertFromModeDegrees() {
        //Given
        Float input = 360f;
        Float expected = 6.2831855f;

        //When
        Float actual = UnitsMode.DEGREES.convertFromMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertFromModeRadians() {
        //Given
        Float input = 360f;
        Float expected = 360f;

        //When
        Float actual = UnitsMode.RADIANS.convertFromMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToModeDegrees() {
        //Given
        Float input = 360f;
        Float expected = 20626.48f;

        //When
        Float actual = UnitsMode.DEGREES.convertToMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToModeRadians() {
        //Given
        Float input = 360f;
        Float expected = 360f;

        //When
        Float actual = UnitsMode.RADIANS.convertToMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNextModeRadians() {
        //Given
        UnitsMode expected = UnitsMode.RADIANS;

        //When
        UnitsMode actual = UnitsMode.DEGREES.getNextMode();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNextModeDegrees() {
        //Given
        UnitsMode expected = UnitsMode.DEGREES;

        //When
        UnitsMode actual = UnitsMode.RADIANS.getNextMode();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateUnitsMode() {
        //Given
        UnitsMode expected = UnitsMode.RADIANS;
        CalculatorOptions.getInstance().setUnitsMode(UnitsMode.DEGREES);

        //When
        CalculatorOptions.getInstance().rotateUnits();

        //Then
        UnitsMode actual = CalculatorOptions.getInstance().getUnitsMode();
        Assert.assertEquals(expected, actual);
    }
}