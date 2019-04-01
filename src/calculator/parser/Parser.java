package calculator.parser;

import calculator.calculations.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.parser.CalculationsEnum.*;

public class Parser {
    public static Calculations parse(String rawInput){
        List<String> brokenInput = breakIntoArray(rawInput);
        List<String> sortedInput = sortByOperation(brokenInput);
        return parseCalculations(sortedInput);
    }

    public static List<String> breakIntoArray(String toBreak){
        toBreak = toBreak.replaceAll("\\s+","").toLowerCase();
        String OPERATORS = "([()+*/\\-^])";
        String NUMBERS = "([\\dacbdef]+(\\.\\d+)?)";
        String LETTERS = "([a-z]+)";
        String REGEX = NUMBERS+"|"+OPERATORS+"|"+LETTERS;
        Pattern tokenPattern = Pattern.compile(REGEX);
        Matcher tokenMatcher = tokenPattern.matcher(toBreak);

        List<String> brokenString = new ArrayList<>();
        String previous = "";
        while (!tokenMatcher.hitEnd()) {
            if (tokenMatcher.find()) {
                String result = tokenMatcher.group();
                if((previous.equals(")") && result.equals("("))|| (previous.equals(")") && isNumeric(result)) || (isNumeric(previous) && result.equals("("))) {
                    brokenString.add("*");
                }
                previous = result;
                brokenString.add(result);
            } else {
                break;
            }
        }
        return brokenString;
    }

    public static List<String> sortByOperation(List<String> unsortedBroken){
        //Djikstra's Shunting Yard
        return ShuntingYard.postfix(unsortedBroken);
    }


    public static Calculations parseCalculations(List<String> sortedList) {
        Stack<Calculations> calculationsStack = new Stack<Calculations>();
        for (int i = 0; i < sortedList.size(); i++) {
            String current = sortedList.get(i);
            if (isNumeric(current)) {
                generateValue(calculationsStack, current);
            } else {
                generateCalculation(calculationsStack, current);
            }
        }
        return calculationsStack.pop();
    }

    private static void generateCalculation(Stack<Calculations> calculationsStack, String current) {
        CalculationsEnum calculation = possibleUserInputs.get(current);
        Calculations valueRight = calculationsStack.pop();
        if (calculation.requiresTwoNumbers()) {
            if (calculationsStack.size() == 0) { calculationsStack.push(new Value("0")); }
            Calculations valueLeft = calculationsStack.pop();
            calculationsStack.push(calculation.generate(valueLeft, valueRight));
        } else {
            calculationsStack.push(calculation.generate(valueRight));
        }
    }


    public static void generateValue(Stack<Calculations> calculationsStack, String current) {
        Value calculations = new Value(current);
        calculationsStack.push(calculations);
    }

    public static boolean isNumeric(String strNum) {
        try {
            float trialFloat = Float.parseFloat(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return strNum.matches("-?[0-9a-fA-F]+");
        }
        return true;
    }

    private static final HashMap<String, CalculationsEnum> possibleUserInputs = new HashMap<>();
    static {
        possibleUserInputs.put("+", ADD);
        possibleUserInputs.put("-", SUBTRACT);
        possibleUserInputs.put("/", DIVIDE);
        possibleUserInputs.put("^", EXPONENT);
        possibleUserInputs.put("*", MULTIPLY);
        possibleUserInputs.put("cos", COSINE); possibleUserInputs.put("cosine", COSINE);
        possibleUserInputs.put("factorial", FACTORIAL);
        possibleUserInputs.put("inverse", INVERSE);
        possibleUserInputs.put("inversecosine", INVERSECOSINE); possibleUserInputs.put("arccos", INVERSECOSINE);
        possibleUserInputs.put("inverselogarithm", INVERSELOGARITHM);
        possibleUserInputs.put("inversenaturallogarithm", INVERSENATURALLOGARITHM);
        possibleUserInputs.put("inversesine", INVERSESINE); possibleUserInputs.put("arcsin", INVERSESINE);
        possibleUserInputs.put("inversetangent", INVERSETANGENT); possibleUserInputs.put("arctan", INVERSETANGENT);
        possibleUserInputs.put("logarithm", LOGARITHM); possibleUserInputs.put("log", LOGARITHM);
        possibleUserInputs.put("naturallogarithm", NATURALLOGARITHM);
        possibleUserInputs.put("sine", SINE); possibleUserInputs.put("sin", SINE);
        possibleUserInputs.put("square", SQUARE);
        possibleUserInputs.put("squareroot", SQUAREROOT); possibleUserInputs.put("sqrt", SQUAREROOT);
        possibleUserInputs.put("switchsign", SWITCHSIGN);
        possibleUserInputs.put("tangent", TANGENT); possibleUserInputs.put("tan", TANGENT);
    }


}
