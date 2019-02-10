import calculations.*;
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
        Calculations expectedCalculations = new Exponent(new Value(5), new Value(2));
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

}
