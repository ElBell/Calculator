import calculations.Calculations;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalcDriver {
    public static void main(String[] args){
        boolean stillRunning = true;
        String currentInput;
        Console io = new Console();
        Parser parser = new Parser();
        String state = "0";

        //io.print("Exit to quit")
        while(stillRunning) {
            io.print(state);
            currentInput = io.getStringInput("Math please:");
            if (!currentInput.replaceAll("\\s+","").toLowerCase().equals("exit")) {
                if (!state.equals("0")) {
                    currentInput = state + currentInput;
                }
                Calculations calculations = parser.parse(currentInput);
                Float answer = calculations.evaluate();
                state = String.format("%.5f", new BigDecimal(answer));
            } else {
                stillRunning = false;
            }

        }
    }
}

