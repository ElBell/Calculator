import calculations.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Parser() {

    }
    public Calculations parse(String rawInput){
        List<String> brokenInput = breakIntoArray(rawInput);
        List<String> sortedInput = sortByOperation(brokenInput);
        Calculations calculationsTree = parseCalculationss(sortedInput);
        return null;//calculationsTree;
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

    public Calculations parseCalculationss(List<String> sortedList){
        Stack<Calculations> calculationssTree = new Stack<Calculations>();
        for(int i = 0;i < sortedList.size(); i++) {
            String current = sortedList.get(i);
            if(current.equals("+")) {
                Calculations valueRight = calculationssTree.pop();
                Calculations valueLeft = calculationssTree.pop();
                Add calculations = new Add(valueLeft, valueRight);
                calculationssTree.push(calculations);
            }else if(current.equals("-")){
                Calculations valueRight = calculationssTree.pop();
                String next = sortedList.get(i+1);
                Calculations valueLeft;
                if(next.isEmpty() || !isNumeric(next)){
                    valueLeft = new Value(0);
                } else {
                    valueLeft = calculationssTree.pop();
                }
                Subtract calculations = new Subtract(valueLeft, valueRight);
                calculationssTree.push(calculations);
            }else if(current.equals("*")){
                Calculations valueRight = calculationssTree.pop();
                Calculations valueLeft = calculationssTree.pop();
                Multiply calculations = new Multiply(valueLeft, valueRight);
                calculationssTree.push(calculations);
            }else if(current.equals("/")){
                Calculations valueRight = calculationssTree.pop();
                Calculations valueLeft = calculationssTree.pop();
                Divide calculations = new Divide(valueLeft, valueRight);
                calculationssTree.push(calculations);
            } else if(current.equals("square")) {
                Calculations value = calculationssTree.pop();
                Square calculations = new Square(value);
                calculationssTree.push(calculations);
            } else if (current.equals("exponent")){
                Calculations valueRight = calculationssTree.pop();
                Calculations valueLeft = calculationssTree.pop();
                Exponent calculations = new Exponent(valueLeft, valueRight);
                calculationssTree.push(calculations);
            } else if (current.equals("sqrt") || current.equals("squareroot")){
                Calculations value = calculationssTree.pop();
                SquareRoot calculations = new SquareRoot(value);
                calculationssTree.push(calculations);
            } else if(current.equals("switchsign") || current.equals("invert")){
                Calculations value = calculationssTree.pop();
                SwitchSign calculations = new SwitchSign(value);
                calculationssTree.push(calculations);
            }
            else {
                //Err
                //break;
            }
        }
        //while(tokens)
        return calculationssTree.pop();
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
