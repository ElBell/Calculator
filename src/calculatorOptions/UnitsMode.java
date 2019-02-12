package calculatorOptions;

public enum UnitsMode {
    DEGREES, RADIANS;

    public float convertFromMode(float number) {
        switch (this) {
            case DEGREES:
                return (float) Math.toRadians((double)number);
            case RADIANS:
            default:
                return number;
        }
    }

    public float convertToMode(float number) {
        switch (this) {
            case DEGREES:
                return (float) Math.toDegrees((double)number);
            case RADIANS:
            default:
                return number;
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
