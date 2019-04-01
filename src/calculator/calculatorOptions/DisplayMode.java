package calculator.calculatorOptions;

public enum DisplayMode {

    BINARY, OCTAL, DECIMAL, HEXADECIMAL;

    public float convertFromMode(String number) {
        switch (this) {
            case HEXADECIMAL:
                int hexNumber = Integer.parseInt(number, 16);
                return (float)hexNumber;
            case BINARY:
                int binaryNumber = Integer.parseInt(number, 2);
                return (float)(binaryNumber);
            case OCTAL:
                int octalNumber = Integer.parseInt(number, 8);
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

