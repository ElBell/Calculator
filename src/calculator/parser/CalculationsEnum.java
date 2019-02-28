package calculator.parser;

import calculator.calculations.*;

import java.util.function.*;

public enum CalculationsEnum {
    COSINE(Cosine::new),
    FACTORIAL(Factorial::new),
    INVERSE(Inverse::new),
    INVERSECOSINE(InverseCosine::new),
    INVERSELOGARITHM(InverseLogarithm::new),
    INVERSENATURALLOGARITHM(InverseNaturalLogarithm::new),
    INVERSESINE(InverseSine::new),
    INVERSETANGENT(InverseTangent::new),
    LOGARITHM(Logarithm::new),
    NATURALLOGARITHM(NaturalLogarithm::new),
    SINE(Sine::new),
    SQUARE(Square::new),
    SQUAREROOT(SquareRoot::new),
    SWITCHSIGN(SwitchSign::new),
    TANGENT(Tangent::new),
    ADD(Add::new),
    SUBTRACT(Subtract::new),
    DIVIDE(Divide::new),
    EXPONENT(Exponent::new),
    MULTIPLY(Multiply::new);

    private BinaryOperator<Calculations> twoValues;
    private UnaryOperator<Calculations> oneValue;
    private Boolean requiresTwoNumbers = false;

    public Boolean requiresTwoNumbers() { return this.requiresTwoNumbers; }

    CalculationsEnum(BinaryOperator<Calculations> values) {
        this.requiresTwoNumbers = true;
        this.twoValues = values;
    }

    CalculationsEnum(UnaryOperator<Calculations> values) {
        this.oneValue = values;
    }

    public Calculations generate(Calculations value1, Calculations value2) {
        this.requiresTwoNumbers = true;
        return twoValues.apply(value1, value2);
    }

    public Calculations generate(Calculations value) {
        return oneValue.apply(value);
    }
}
