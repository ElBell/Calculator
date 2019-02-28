package calculator.calculatorOptions;

public enum DisplayMode {

    /**
     *
     *     BINARY(        (number, someString) -> {
     *         Integer hexNumber = Integer.parseInt(number, 16);
     *         return (float)hexNumber;
     *     }),
     *     OCTAL,
     *     DECIMAL,
     *     HEXADECIMAL;
     *     private final Function<String, Float> functionToBeCalled;
     *
     *     DisplayMode(BiFunction<String, String, Float> functionToBeCalled) {
     *         this.functionToBeCalled = functionToBeCalled;
     *     }
     *     public Object convert(String number) {
     *
     *         function.apply()
     *
     *     }
     */

    BINARY, OCTAL, DECIMAL, HEXADECIMAL;

    public float convertFromMode(String number) {
        switch (this) {
            case HEXADECIMAL:
                Integer hexNumber = Integer.parseInt(number, 16);
                return (float)hexNumber;
            case BINARY:
                Integer binaryNumber = Integer.parseInt(number, 2);
                return (float)(binaryNumber);
            case OCTAL:
                Integer octalNumber = Integer.parseInt(number, 8);
                return (float)octalNumber;
            case DECIMAL:
            default:
                return Float.parseFloat(number);
        }
    }

    public String convertToMode(float number) {
        switch (this) {
            case HEXADECIMAL:
                return Integer.toHexString((int)number);
            case BINARY:
                return Integer.toBinaryString((int)number);
            case OCTAL:
                return Integer.toOctalString((int)number);
            case DECIMAL:
            default:
                return Float.toString(number);
        }
    }

    public DisplayMode getNextMode() {
        switch (this) {
            case HEXADECIMAL:
                return BINARY;
            case BINARY:
                return OCTAL;
            case OCTAL:
                return DECIMAL;
            case DECIMAL:
            default:
                return HEXADECIMAL;
        }
    }

}

