import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Parser() {

    }
    public Calculations parse(String rawInput){
        List<String> brokenInput = breakIntoArray(rawInput);
        List<String> sortedInput = sortByOperation(brokenInput);
        Calculations calculationTree = parseCalculations(sortedInput);
        return null;//calculationTree;
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

    public Calculations parseCalculations(List<String> sortedList){
        Stack<Calculations> calculationsTree = new Stack<Calculations>();
        for(int i = 0;i < sortedList.size(); i++) {
            String current = sortedList.get(i);
            if(current.equals("+")) {
                Calculation valueRight = calculationsTree.pop();
                Calculation valueLeft = calculationsTree.pop();
                Add calculation = new Add(valueLeft, valueRight);
                calculationsTree.push(calculation);
            }else if(current.equals("-")){
                Calculation valueRight = calculationsTree.pop();
                String next = sortedQueue.peek();
                if(next.isEmpty() || !isNumeric(next)){calculationsTree.push();}
                Calculation valueLeft = calculationsTree.pop();
                Subtract calculation = new Subtract(valueLeft, valueRight);
                calculationsTree.push(calculation);
            }else if(current.equals("*")){
                Calculation valueRight = calculationsTree.pop();
                Calculation valueLeft = calculationsTree.pop();
                Multipy calculation = new Multipy(valueLeft, valueRight);
                calculationsTree.push(calculation);
            }else if(current.equals("/")){
                Calculation valueRight = calculationsTree.pop();
                Calculation valueLeft = calculationsTree.pop();
                Divide calculation = new Divide(valueLeft, valueRight);
                calculationsTree.push(calculation);
            } else if(current.equals("square")) {
                Calculation value = calculationsTree.pop();
                Square calculation = new Square(value);
                calculationsTree.push(calculation);
            } else if (current.equals("exponent")){
                Calculation valueRight = calculationsTree.pop();
                Calculation valueLeft = calculationsTree.pop();
                Exponent calculation = new Exponent(valueLeft, valueRight);
                calculationsTree.push(calculation);
            } else if (current.equals("sqrt") || current.equals("squareroot")){
                Calculation value = calculationsTree.pop();
                SquareRoot calculation = new SquareRoot(value);
                calculationsTree.push(calculation);
            } else if(current.equals("switchsign") || current.equals("invert")){
                Calculation value = calculationsTree.pop();
                SwitchSign calculation = new SwitchSign(value);
                calculationsTree.push(calculation);
            }
            else {
                //Err
                //break;
            }
        }
        //while(tokens)
        return calculationsTree.pop();
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
