package calculations;

import calculations.Calculations;

public class Value implements Calculations {
     float number;
     public Value(float number){
         this.number = number;
     }
     public float evaluate() {
         return number;
     }
}
