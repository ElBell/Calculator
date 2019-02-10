
public class CalcDriver {
    public static void main(String[] args){}

    public CalcDriver() {


        boolean stillRunning = true;
        String expression = "";
        Console io = new Console();
        float actualResult;

        // Elenor's parser
        Parser ps = new Parser();

        io.print("Exit to quit");

        while (stillRunning) {


            io.print("Expression");
            expression = io.getStringInput("");

            if ("exit".equals(expression.toLowerCase())) {
                stillRunning = false;
            }


        }
    }
}

