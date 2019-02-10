package calculatorOptions;

public enum UnitsMode {
    DEGREES, RADIANS;

    public float convertFromMode(String number) {
        switch (this) {
            case DEGREES:
                //return Math.toRadians(Float.parseFloat(number));
            case RADIANS:
            default:
                return Float.parseFloat(number);
        }
    }

    public String convertToMode(float number) {
        switch (this) {
            case DEGREES:
                return Float.toHexString(number);
            case RADIANS:
            default:
                return Float.toString(number);
        }
    }

    public UnitsMode getNextMode() {
        switch (this) {
            case DEGREES:
                return RADIANS;
            case RADIANS:
            default:
                return DEGREES;
        }
    }
}
