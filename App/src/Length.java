public class Length {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        public double getFactor() {
            return factor;
        }
    }

    private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    // Convert to base (inches)
    private double toBase() {
        return value * unit.getFactor();
    }

    // Convert to target unit (UC5 main logic)
    public Length convertTo(LengthUnit target) {
        if (target == null) throw new IllegalArgumentException("Target unit null");

        double base = toBase();
        double converted = base / target.getFactor();

        // round to 2 decimal places
        converted = Math.round(converted * 100.0) / 100.0;

        return new Length(converted, target);
    }

    // static conversion API
    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (from == null || to == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        double base = value * from.getFactor();
        return base / to.getFactor();
    }

    // equality with tolerance
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;

        double diff = Math.abs(this.toBase() - other.toBase());
        return diff < 0.0001;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(toBase());
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}