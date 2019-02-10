import calculations.Calculations;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CalculatorDriver {
    public static void main(String[] args){
        boolean stillRunning = true;
        String currentInput;
        Console io = new Console();
        Parser parser = new Parser();
        String internalValue = "0";

        //io.print("Exit to quit")
        while(stillRunning) {
            io.print(internalValue);
            currentInput = io.getStringInput("Math please:");
            if (!currentInput.replaceAll("\\s+","").toLowerCase().equals("exit")) {
                if (!internalValue.equals("0")) {
                    currentInput = internalValue + currentInput;
                }
                Calculations calculations = parser.parse(currentInput);
                Float answer = calculations.evaluate();
                internalValue = String.format("%.5f", new BigDecimal(answer));
            } else {
                stillRunning = false;
            }

        }
    }
}

