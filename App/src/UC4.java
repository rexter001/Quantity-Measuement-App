public class UC4 {

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public static class Length {
        private final double value;
        private final LengthUnit unit;

        public Length(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // Convert to inches
        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        // FIXED: tolerance-based comparison
        public boolean compare(Length that) {
            double diff = Math.abs(
                    this.convertToBaseUnit() - that.convertToBaseUnit()
            );
            return diff < 0.0001;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Length other = (Length) obj;
            return this.compare(other);
        }

        @Override
        public int hashCode() {
            return Double.hashCode(convertToBaseUnit());
        }
    }

    public static boolean demonstrateLengthComparison(
            double v1, LengthUnit u1,
            double v2, LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }
    public static void main(String[] args) {

        System.out.println(
                demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET)
        );

        System.out.println(
                demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES)
        );
        System.out.println(
                demonstrateLengthComparison(100.0, LengthUnit.CENTIMETERS, 39.3701, LengthUnit.INCHES)
        );
    }
}