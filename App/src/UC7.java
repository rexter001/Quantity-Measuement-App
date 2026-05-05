package com.apps.quantitymeasurement;

public class UC7 {

    private double value;
    private LengthUnit unit;

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

    public UC7(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to inches
    private double toBase() {
        return value * unit.getConversionFactor();
    }

    // Convert from inches
    private double fromBase(double base, LengthUnit target) {
        return base / target.getConversionFactor();
    }

    // 🔥 UC6 method (keep it)
    public UC7 add(UC7 that) {
        double sum = this.toBase() + that.toBase();
        double result = fromBase(sum, this.unit);
        return new UC7(result, this.unit);
    }

    // 🚀 UC7 method (NEW)
    public UC7 add(UC7 that, LengthUnit targetUnit) {

        if (that == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sum = this.toBase() + that.toBase();

        double result = fromBase(sum, targetUnit);

        return new UC7(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UC7 other = (UC7) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}