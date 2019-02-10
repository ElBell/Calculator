import java.util.*;

//https://eddmann.com/posts/shunting-yard-implementation-in-java/
// Eleonor added the infix exponent operator, the validFunctions. Converted the storing method,
// output, and input from String to List<String>

public class ShuntingYard {

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);//, EXPONENT(5);
        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    private static Map<String, Operator> operators = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
        //put("^", Operator.EXPONENT);
    }};

    private static Set<String> validFunctions = new HashSet<String>() {{
        add("exponent");
        add("^");
        add("factorial");
        add("inverse");
        add("xor");
        add("square");
        add("squareroot");
        add("switchsign");
        add("sqrt");
        add("invert");
        add("sine");
        add("sin");
        add("cosine");
        add("cos");
        add("tangent");
        add("tan");
        add("inversesine");
        add("inversesin");
        add("inversecosine");
        add("inversecos");
        add("inversetangent");
        add("inversetan");
        add("logarithm");
        add("log");
        add("inverselogarithm");
        add("inverselog");
        add("naturallogarithm");
        add("naturallog");
        add("inversenaturallogarithm");
        add("inversenaturallog");
    }};

    private static boolean isHigerPrec(String op, String sub) {
        return (operators.containsKey(sub) && operators.get(sub).precedence >= operators.get(op).precedence);
    }

    public static List postfix(List<String> infix) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();

        for (String token : infix) {
            // operator
            if (operators.containsKey(token)) {
                while (!stack.isEmpty() && (
                        validFunctions.contains(stack.peek()) || isHigerPrec(token, stack.peek())))
                    output.add(stack.pop());
                stack.push(token);

                // left parenthesis
            } else if (token.equals("(")) {
                stack.push(token);

                // right parenthesis
            } else if (token.equals(")")) {
                while (!stack.peek().equals("("))
                    output.add(stack.pop());
                stack.pop();

                // digit
            } else if (validFunctions.contains(token)) {
                stack.push(token);
            } else {
                output.add(token);
            }
        }

        while (!stack.isEmpty())
            output.add(stack.pop());

        return output;
    }
}
