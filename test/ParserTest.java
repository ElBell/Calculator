import calculator.calculations.*;
import calculator.calculatorOptions.CalculatorOptions;
import calculator.calculatorOptions.DisplayMode;
import calculator.parser.Parser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class ParserTest {
    @Test
    public void testBreakIntoArray() {
        // Given
        String testString = "square(5+5 * 18 + square(4))";
        // When
        List<String> actualList = Parser.breakIntoArray(testString);
        // Then
        List<String> expectedList = Arrays.asList("square", "(", "5", "+", "5", "*", "18", "+", "square", "(", "4", ")", ")");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation1() {
        // Given
        List<String> testList = Arrays.asList("(", "5", "+", "5", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = Parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "18", "*", "+", "4", "+");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation2() {
        // Given
        List<String> testList = Arrays.asList("square", "(", "5", "+", "5", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = Parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "18", "*", "+", "4", "+", "square");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation3() {
        // Given
        List<String> testList = Arrays.asList("square", "(", "5", "+", "square", "(", "5", ")", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = Parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "square", "18", "*", "+", "4", "+", "square");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation4() {
        // Given
        List<String> testList = Arrays.asList("squareroot", "(", "5", "+", "squareroot", "(", "5", ")", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = Parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "squareroot", "18", "*", "+", "4", "+", "squareroot");
        Assert.assertEquals(expectedList, actualList);

    }
    @Test
    public void testSortByOperation5() {
        // Given
        List<String> testList = Arrays.asList("2", "^", "2", "+", "5");
        // When
        List<String> actualList = Parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("2", "2", "^", "5", "+");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testGenerateCosine() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("0");
        sortedList.add("cosine");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Float expectedAnswer = 1f;
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateSine() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("sine");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Sine(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateTangent() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("tan");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Tangent(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateInverseTangent() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("inversetangent");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new InverseTangent(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateInverseSine() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("inversesine");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new InverseSine(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateInverseCosine() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("inversecosine");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new InverseCosine(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }



    @Test
    public void testGenerateSwitchSign() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("switchsign");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new SwitchSign(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateSquareRoot() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("squareroot");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new SquareRoot(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateExponent() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("2");
        sortedList.add("^");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Exponent(new Value(5), new Value(2));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateSquare() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("square");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Square(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateDivide() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("2");
        sortedList.add("/");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Divide(new Value(5), new Value(2));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateMultiply() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("2");
        sortedList.add("*");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Multiply(new Value(5), new Value(2));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateAdd() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("2");
        sortedList.add("+");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Add(new Value(5), new Value(2));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateFactorial() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("factorial");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Factorial(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateInverse() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("inverse");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Inverse(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateLogarithm() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("log");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Logarithm(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateInverseLogarithm() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("inverselogarithm");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new InverseLogarithm(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateNaturalLogarithm() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("naturallogarithm");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new NaturalLogarithm(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateInverseNaturalLogarithm() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("inversenaturallogarithm");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new InverseNaturalLogarithm(new Value(5));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateSubtract() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("5");
        sortedList.add("2");
        sortedList.add("-");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Subtract(new Value(5), new Value(2));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateSubtractNone() {
        // Given
        List<String> sortedList = new ArrayList<>();
        sortedList.add("2");
        sortedList.add("-");
        //When
        Calculations actualCalculations = Parser.parseCalculations(sortedList);
        //Then
        Calculations expectedCalculations = new Subtract(new Value(0), new Value(2));
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedCalculations.evaluate(), actualAnswer, 0.1);
    }

    @Test
    public void testGenerateValue() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        //When
        Parser.generateValue(testCalculationStack, "5");
        //Then
        Calculations expectedCalculations = new Value(5);
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testIsNumericTrue() {
        // Given
        String string = "156664";
        // When
        boolean actualResult = Parser.isNumeric(string);
        // Then
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsNumericFalse() {
        // Given
        String string = "square";
        // When
        boolean actualResult = Parser.isNumeric(string);
        // Then
        boolean expectedResult = false;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testParseCalculations() {
        // Given
        List<String> testList = new ArrayList<>();
        testList.add("5");
        testList.add("5");
        testList.add("+");
        // When
        Calculations actualCalculations = Parser.parseCalculations(testList);
        //Then
        Calculations expectedCalculations = new Add(new Value(5), new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testParseCalculations2() {
        // Given
        List<String> testList = new ArrayList<>();
        testList.add("5");
        testList.add("3");
        testList.add("square");
        testList.add("+");
        testList.add("6");
        testList.add("+");
        testList.add("square");
        // When
        Calculations actualCalculations = Parser.parseCalculations(testList);
        //Then
        Calculations expectedCalculations = new Square(new Add(new Add(new Value(5), new Square(new Value(3))), new Value(6)));
        Float expectedAnswer = expectedCalculations.evaluate();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testParseCalculations3() {
        // Given
        List<String> testList = new ArrayList<>();
        testList.add("5");
        testList.add("3");
        testList.add("/");
        testList.add("8");
        testList.add("*");
        // When
        Calculations actualCalculations = Parser.parseCalculations(testList);
        //Then
        Calculations expectedCalculations = new Multiply(new Divide(new Value(5), new Value(3)), new Value(8));
        Float expectedAnswer = expectedCalculations.evaluate();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testParseCalculations4() {
        // Given
        List<String> testList = new ArrayList<>();
        testList.add("5");
        testList.add("3");
        testList.add("^");

        // When
        Calculations actualCalculations = Parser.parseCalculations(testList);
        //Then
        Calculations expectedCalculations = new Exponent(new Value(5), new Value(3));
        Float expectedAnswer = expectedCalculations.evaluate();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }


    @Test
    public void testHex() {
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.HEXADECIMAL);
        // Given
        String hexCalculation = "A+1";
        // When
        List<String> testList = Parser.breakIntoArray(hexCalculation);
        List<String> sortedInput = Parser.sortByOperation(testList);
        Calculations actualCalculations = Parser.parseCalculations(sortedInput);

        //Then;
        Float expectedAnswer = 11f;
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testSubtractParsing() {
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.DECIMAL);
        // Given
        String calculation = "5-4";
        // When
        List<String> testList = Parser.breakIntoArray(calculation);
        List<String> sortedInput = Parser.sortByOperation(testList);
        Calculations actualCalculations = Parser.parseCalculations(sortedInput);

        //Then;
        Float expectedAnswer = 1f;
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testParser() {
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.DECIMAL);
        //Given
        String calculations_input = "5 + 6 * 2";
        Float expected = 17f;

        //When
        Calculations calculations = Parser.parse(calculations_input);
        Float actual = calculations.evaluate();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParserParenthesis() {
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.DECIMAL);
        //Given
        String input_parenthesis = "5 * ( 7 + 1 )";
        String input_noparenthesis = "5 * 7 + 1 ";
        Float expected = 40f;
        Float expected2 = 36f;


        //When
        Calculations calculations = Parser.parse(input_parenthesis);
        Float actual = calculations.evaluate();
        Calculations calculations2 = Parser.parse(input_noparenthesis);
        Float actual2 = calculations2.evaluate();

        //Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testParserParenthesisAsMultiply() {
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.DECIMAL);
        //Given
        String input_parenthesis = "(5)(9)";
        String input_noparenthesis = "5 * 9";

        //When
        Calculations calculations = Parser.parse(input_parenthesis);
        Float actual = calculations.evaluate();
        Calculations calculations2 = Parser.parse(input_noparenthesis);
        Float expected = calculations2.evaluate();

        //Then
        Assert.assertEquals(expected, actual);
    }


}
