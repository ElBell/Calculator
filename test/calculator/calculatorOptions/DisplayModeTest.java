package calculator.calculatorOptions;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayModeTest {

    @Test
    public void convertFromModeOctal() {
        //Given
        String input = "15";
        Float expected = 13f;

        //When
        Float actual = DisplayMode.OCTAL.convertFromMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToModeHexadecimal() {
        //Given
        Float input = 15f;
        String expected = "f";

        //When
        String actual = DisplayMode.HEXADECIMAL.convertToMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToModeBinary() {
        //Given
        Float input = 15f;
        String expected = "1111";

        //When
        String actual = DisplayMode.BINARY.convertToMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToModeOctal() {
        //Given
        Float input = 15f;
        String expected = "17";

        //When
        String actual = DisplayMode.OCTAL.convertToMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convertToModeDecimal() {
        //Given
        Float input = 15f;
        String expected = "15.0";

        //When
        String actual = DisplayMode.DECIMAL.convertToMode(input);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNextModeDecimal() {
        //Given
        DisplayMode expected = DisplayMode.DECIMAL;

        //When
        DisplayMode actual = DisplayMode.OCTAL.getNextMode();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNextModeHexadecimal() {
        //Given
        DisplayMode expected = DisplayMode.HEXADECIMAL;

        //When
        DisplayMode actual = DisplayMode.DECIMAL.getNextMode();

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getNextModeBinary() {
        //Given
        DisplayMode expected = DisplayMode.BINARY;

        //When
        DisplayMode actual = DisplayMode.HEXADECIMAL.getNextMode();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNextModeOctal() {
        //Given
        DisplayMode expected = DisplayMode.OCTAL;

        //When
        DisplayMode actual = DisplayMode.BINARY.getNextMode();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rotateDisplayMode() {
        //Given
        DisplayMode expected = DisplayMode.OCTAL;
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.BINARY);

        //When
        CalculatorOptions.getInstance().rotateMode();

        //Then
        DisplayMode actual = CalculatorOptions.getInstance().getDisplayMode();
        Assert.assertEquals(expected, actual);
    }
}