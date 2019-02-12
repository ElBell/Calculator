package calculations;

import calculatorOptions.CalculatorOptions;
import calculatorOptions.DisplayMode;

public class Value implements Calculations {
     String number;
     public Value(String number){
         this.number = number;
     }
     public Value(float number){
        this.number = Float.toString(number);
    }
     public Value(int number){
        this.number = Integer.toString(number);
    }
     public float evaluate() {
         DisplayMode mode = CalculatorOptions.getInstance().getDisplayMode();
         return mode.convertFromMode(number);
     }
}
