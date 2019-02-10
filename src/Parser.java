import calculations.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Parser() {

    }
    public Calculations parse(String rawInput){
        List<String> brokenInput = breakIntoArray(rawInput);
        List<String> sortedInput = sortByOperation(brokenInput);
        Calculations calculationsStack = parseCalculations(sortedInput);
        return calculationsStack;
    }

    public List<String> breakIntoArray(String toBreak){
        toBreak = toBreak.replaceAll("\\s+","").toLowerCase();
        String OPERATORS = "([\\(\\)+*/-])";
        String NUMBERS = "(\\d+(\\.\\d+)?)";
        String LETTERS = "([a-z]+)";
        String REGEX = NUMBERS+"|"+OPERATORS+"|"+LETTERS;
        Pattern tokenPattern = Pattern.compile(REGEX);
        Matcher tokenMatcher = tokenPattern.matcher(toBreak);

        List<String> brokenString = new ArrayList<>();
        while (!tokenMatcher.hitEnd()) {
            if (tokenMatcher.find()) {
                String result = tokenMatcher.group();
                brokenString.add(result);
            } else {
                break;
            }
        }
        return brokenString;
    }

    public List<String> sortByOperation(List<String> unsortedBroken){
        //Djikstra's Shunting Yard
        List<String> sorted = ShuntingYard.postfix(unsortedBroken);
        //return null;
        return sorted;
    }

    public static Calculations parseCalculations(List<String> sortedList){
        Stack<Calculations> calculationsStack = new Stack<Calculations>();
        for(int i = 0;i < sortedList.size(); i++) {
            String current = sortedList.get(i);
            if(current.equals("+")) {
                generateAdd(calculationsStack);
            }else if(current.equals("-")){
                String next = "";
                if(i + 1 != sortedList.size()){ next = sortedList.get(i+1);}
                generateSubtract(calculationsStack, next);
            }else if(current.equals("*")){
                generateMultiply(calculationsStack);
            }else if(current.equals("/")){
                generateDivide(calculationsStack);
            } else if(current.equals("square")) {
                generateSquare(calculationsStack);
            } else if (current.equals("exponent")){
                generateExponent(calculationsStack);
            } else if (current.equals("sqrt") || current.equals("squareroot")){
                generateSquareRoot(calculationsStack);
            } else if(current.equals("switchsign") || current.equals("invert")){
                generateSwitchSign(calculationsStack);
            } else if(current.equals("factorial")){
                generateFactorial(calculationsStack);
            } else if(current.equals("inverse")){
                generateInverse(calculationsStack);
            } else if(isNumeric(current)) {
                generateValue(calculationsStack, current);
            }
        }
        //while(tokens)
        return calculationsStack.pop();
    }

    public static void generateValue(Stack<Calculations> calculationsStack, String current) {
        Float value = Float.parseFloat(current);
        Value calculations = new Value(value);
        calculationsStack.push(calculations);
    }

    public static void generateInverse(Stack<Calculations> calculationsStack) {
        Calculations value = calculationsStack.pop();
        Inverse calculations = new Inverse(value);
        calculationsStack.push(calculations);
    }

    public static void generateFactorial(Stack<Calculations> calculationsStack) {
        Calculations value = calculationsStack.pop();
        Factorial calculations = new Factorial(value);
        calculationsStack.push(calculations);
    }

    public static void generateSwitchSign(Stack<Calculations> calculationsStack) {
        Calculations value = calculationsStack.pop();
        SwitchSign calculations = new SwitchSign(value);
        calculationsStack.push(calculations);
    }

    public static void generateSquareRoot(Stack<Calculations> calculationsStack) {
        Calculations value = calculationsStack.pop();
        SquareRoot calculations = new SquareRoot(value);
        calculationsStack.push(calculations);
    }

    public static void generateExponent(Stack<Calculations> calculationsStack) {
        Calculations valueRight = calculationsStack.pop();
        Calculations valueLeft = calculationsStack.pop();
        Exponent calculations = new Exponent(valueLeft, valueRight);
        calculationsStack.push(calculations);
    }

    public static void generateSquare(Stack<Calculations> calculationsStack) {
        Calculations value = calculationsStack.pop();
        Square calculations = new Square(value);
        calculationsStack.push(calculations);
    }

    public static void generateDivide(Stack<Calculations> calculationsStack) {
        Calculations valueRight = calculationsStack.pop();
        Calculations valueLeft = calculationsStack.pop();
        Divide calculations = new Divide(valueLeft, valueRight);
        calculationsStack.push(calculations);
    }

    public static void generateMultiply(Stack<Calculations> calculationsStack) {
        Calculations valueRight = calculationsStack.pop();
        Calculations valueLeft = calculationsStack.pop();
        Multiply calculations = new Multiply(valueLeft, valueRight);
        calculationsStack.push(calculations);
    }

    public static void generateSubtract(Stack<Calculations> calculationsStack, String next) {
        Calculations valueRight = calculationsStack.pop();
        Calculations valueLeft;
        if(next.isEmpty() || !isNumeric(next)){
            valueLeft = new Value(0);
        } else {
            valueLeft = calculationsStack.pop();
        }
        Subtract calculations = new Subtract(valueLeft, valueRight);
        calculationsStack.push(calculations);
    }

    public static void generateAdd(Stack<Calculations> calculationsStack) {
        Calculations valueRight = calculationsStack.pop();
        Calculations valueLeft = calculationsStack.pop();
        Add calculations = new Add(valueLeft, valueRight);
        calculationsStack.push(calculations);
    }


    public static boolean isNumeric(String strNum) {
        try {
            float trialFloat = Float.parseFloat(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }


}
