package calculatorOptions;

public enum DisplayMode {

    BINARY, OCTAL, DECIMAL, HEXADECIMAL;

    public float convertFromMode(String number) {
        switch (this) {
            case HEXADECIMAL:
                Long hexNumber = Long.parseLong(number, 16);
                return Float.intBitsToFloat(hexNumber.intValue());
            case BINARY:
                Long binaryNumber = Long.parseLong(number, 2);
                return Float.intBitsToFloat(binaryNumber.intValue());
            case OCTAL:
                Long octalNumber = Long.parseLong(number, 8);
                return Float.intBitsToFloat(octalNumber.intValue());
            case DECIMAL:
            default:
                return Float.parseFloat(number);
        }
    }

    public String convertToMode(float number) {
        switch (this) {
            case HEXADECIMAL:
                return Float.toHexString(number);
            case BINARY:
                long bits = Double.doubleToLongBits(number);
                return Long.toBinaryString(bits);
            case OCTAL:
                long octalBits = Double.doubleToLongBits(number);
                return Long.toOctalString(octalBits);
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

