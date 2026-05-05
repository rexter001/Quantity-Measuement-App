package com.apps.quantitymeasurement;

public class UC6 {

    private double value;
    private LengthUnit unit;

    // ENUM
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

    // CONSTRUCTOR
    public UC6(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // GETTERS
    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to base (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Convert from base to target
    private double convertFromBase(double baseValue, LengthUnit target) {
        return baseValue / target.getConversionFactor();
    }

    // STATIC CONVERT (UC5 reuse)
    public static double convert(double value, LengthUnit from, LengthUnit to) {
        double base = value * from.getConversionFactor();
        return base / to.getConversionFactor();
    }

    // UC6 ADD METHOD 🔥
    public UC6 add(UC6 that) {

        if (that == null) {
            throw new IllegalArgumentException("Cannot add null");
        }

        double sumInBase =
                this.convertToBaseUnit() +
                        that.convertToBaseUnit();

        double result =
                convertFromBase(sumInBase, this.unit);

        return new UC6(result, this.unit);
    }

    // EQUALS
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UC6 other = (UC6) obj;

        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()
        ) == 0;
    }
}
