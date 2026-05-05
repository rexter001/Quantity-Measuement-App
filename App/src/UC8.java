package com.apps.quantitymeasurement;

public class UC8 {

    private double value;
    private LengthUnit unit;

    // 🔥 Standalone enum (UC8 concept applied INSIDE UC8 for your naming requirement)
    public enum LengthUnit {

        // Base = FEET
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double factor;

        LengthUnit(double factor) {
            this.factor = factor;
        }

        // Convert TO base (feet)
        public double toBase(double value) {
            return value * factor;
        }

        // Convert FROM base (feet)
        public double fromBase(double base) {
            return base / factor;
        }
    }

    // Constructor
    public UC8(double value, LengthUnit unit) {

        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // Convert to base
    private double toBase() {
        return unit.toBase(value);
    }

    // Convert to another unit
    public UC8 convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = toBase();
        double result = targetUnit.fromBase(base);

        return new UC8(result, targetUnit);
    }

    // UC6 add
    public UC8 add(UC8 that) {
        return add(that, this.unit);
    }

    // UC7 + UC8 add with target
    public UC8 add(UC8 that, LengthUnit targetUnit) {

        if (that == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase = this.toBase() + that.toBase();

        double result = targetUnit.fromBase(sumBase);

        return new UC8(result, targetUnit);
    }

    // equals
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UC8 other = (UC8) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}