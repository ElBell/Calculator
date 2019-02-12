import calculations.*;
import calculatorOptions.CalculatorOptions;
import calculatorOptions.DisplayMode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class ParserTest {
    Parser parser;
    @Before
    public void setup() {
        parser = new Parser();
    }

    @Test
    public void testBreakIntoArray() {
        // Given
        String testString = "square(5+5 * 18 + square(4))";
        // When
        List<String> actualList = parser.breakIntoArray(testString);
        // Then
        List<String> expectedList = Arrays.asList("square", "(", "5", "+", "5", "*", "18", "+", "square", "(", "4", ")", ")");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation1() {
        // Given
        List<String> testList = Arrays.asList("(", "5", "+", "5", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "18", "*", "+", "4", "+");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation2() {
        // Given
        List<String> testList = Arrays.asList("square", "(", "5", "+", "5", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "18", "*", "+", "4", "+", "square");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation3() {
        // Given
        List<String> testList = Arrays.asList("square", "(", "5", "+", "square", "(", "5", ")", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "square", "18", "*", "+", "4", "+", "square");
        Assert.assertEquals(expectedList, actualList);

    }

    @Test
    public void testSortByOperation4() {
        // Given
        List<String> testList = Arrays.asList("squareroot", "(", "5", "+", "squareroot", "(", "5", ")", "*", "18", "+", "4", ")");
        // When
        List<String> actualList = parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("5", "5", "squareroot", "18", "*", "+", "4", "+", "squareroot");
        Assert.assertEquals(expectedList, actualList);

    }
    @Test
    public void testSortByOperation5() {
        // Given
        List<String> testList = Arrays.asList("2", "^", "2", "+", "5");
        // When
        List<String> actualList = parser.sortByOperation(testList);
        // Then
        List<String> expectedList = Arrays.asList("2", "2", "^", "5", "+");
        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void testGenerateCosine() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(0));
        //When
        parser.generateCosine(testCalculationStack);
        //Then
        Float expectedAnswer = 1f;
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateSine() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //Whens
        parser.generateSine(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Sine(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateTangent() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateTangent(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Tangent(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateInverseTangent() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateInverseTangent(testCalculationStack);
        //Then
        Calculations expectedCalculations = new InverseTangent(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateInverseSine() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateInverseSine(testCalculationStack);
        //Then
        Calculations expectedCalculations = new InverseSine(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateInverseCosine() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateInverseCosine(testCalculationStack);
        //Then
        Calculations expectedCalculations = new InverseCosine(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }



    @Test
    public void testGenerateSwitchSign() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateSwitchSign(testCalculationStack);
        //Then
        Calculations expectedCalculations = new SwitchSign(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateSquareRoot() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(25));
        //When
        parser.generateSquareRoot(testCalculationStack);
        //Then
        Calculations expectedCalculations = new SquareRoot(new Value(25));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateExponent() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        testCalculationStack.add(new Value(2));
        //When
        parser.generateExponent(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Exponent(new Value(2), new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateSquare() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateSquare(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Square(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateDivide() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(10));
        testCalculationStack.add(new Value(2));
        //When
        parser.generateDivide(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Divide(new Value(10), new Value(2));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateMultiply() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(10));
        testCalculationStack.add(new Value(2));
        //When
        parser.generateMultiply(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Multiply(new Value(10), new Value(2));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateAdd() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(10));
        testCalculationStack.add(new Value(2));
        //When
        parser.generateAdd(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Add(new Value(10), new Value(2));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateFactorial() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateFactorial(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Factorial(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateInverse() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateInverse(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Inverse(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateLogarithm() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateLogarithm(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Logarithm(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateInverseLogarithm() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateInverseLogarithm(testCalculationStack);
        //Then
        Calculations expectedCalculations = new InverseLogarithm(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateNaturalLogarithm() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateNaturalLogarithm(testCalculationStack);
        //Then
        Calculations expectedCalculations = new NaturalLogarithm(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateInverseNaturalLogarithm() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(5));
        //When
        parser.generateInverseNaturalLogarithm(testCalculationStack);
        //Then
        Calculations expectedCalculations = new InverseNaturalLogarithm(new Value(5));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }



    @Test
    public void testGenerateXor() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(2));
        testCalculationStack.add(new Value(5));
        //When
        parser.generateXOR(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Xor(new Value(5), new Value(2));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateValue() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        //When
        parser.generateValue(testCalculationStack, "5");
        //Then
        Calculations expectedCalculations = new Value(5);
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateSubtract() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(10));
        testCalculationStack.add(new Value(2));
        //When
        parser.generateSubtract(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Subtract(new Value(10), new Value(2));
        Float expectedAnswer = expectedCalculations.evaluate();
        Calculations actualCalculations = testCalculationStack.pop();
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testGenerateSubtractNone() {
        // Given
        Stack<Calculations> testCalculationStack = new Stack<>();
        testCalculationStack.add(new Value(10));
        //When
        parser.generateSubtract(testCalculationStack);
        //Then
        Calculations expectedCalculations = new Subtract(new Value(0), new Value(10));
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
        boolean actualResult = parser.isNumeric(string);
        // Then
        boolean expectedResult = true;
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsNumericFalse() {
        // Given
        String string = "square";
        // When
        boolean actualResult = parser.isNumeric(string);
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
        Calculations actualCalculations = parser.parseCalculations(testList);
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
        Calculations actualCalculations = parser.parseCalculations(testList);
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
        Calculations actualCalculations = parser.parseCalculations(testList);
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
        Calculations actualCalculations = parser.parseCalculations(testList);
        //Then
        Calculations expectedCalculations = new Exponent(new Value(3), new Value(5));
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
        Parser parse = new Parser();
        List<String> testList = parse.breakIntoArray(hexCalculation);
        List<String> sortedInput = parse.sortByOperation(testList);
        Calculations actualCalculations = parser.parseCalculations(sortedInput);

        //Then;
        Float expectedAnswer = 11f;
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testSubtractParsing() {
        CalculatorOptions.getInstance().setDisplayMode(DisplayMode.DECIMAL);
        // Given
        String hexCalculation = "5-4";
        // When
        Parser parse = new Parser();
        List<String> testList = parse.breakIntoArray(hexCalculation);
        List<String> sortedInput = parse.sortByOperation(testList);
        Calculations actualCalculations = parser.parseCalculations(sortedInput);

        //Then;
        Float expectedAnswer = 1f;
        Float actualAnswer = actualCalculations.evaluate();
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }


}
