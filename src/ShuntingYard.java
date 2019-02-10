import java.util.*;

//All credit to https://eddmann.com/posts/shunting-yard-implementation-in-java/

public class ShuntingYard {

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4), ;
        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    private static Map<String, Operator> ops = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
    }};

    private static Set<String> validFunctions = new HashSet<String>() {{
        add("exponent");
        add("factorial");
        add("inversenumber");
        add("square");
        add("squareroot");
        add("switchsign");
    }};

    private static boolean isHigerPrec(String op, String sub) {
        return (ops.containsKey(sub) && ops.get(sub).precedence >= ops.get(op).precedence);
    }

    public static List postfix(List<String> infix) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();

        for (String token : infix) {
            // operator
            if (ops.containsKey(token)) {
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
