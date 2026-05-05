package com.apps.quantitymeasurement;

public class UC9 {

    private final double value;
    private final WeightUnit unit;

    // 🔥 Standalone-style enum (embedded for your naming requirement)
    public enum WeightUnit {

        // Base = KILOGRAM
        KILOGRAM(1.0),
        GRAM(0.001),
        POUND(0.453592);

        private final double factor;

        WeightUnit(double factor) {
            this.factor = factor;
        }

        // Convert TO base (kg)
        public double toBase(double value) {
            return value * factor;
        }

        // Convert FROM base (kg)
        public double fromBase(double base) {
            return base / factor;
        }
    }

    // Constructor
    public UC9(double value, WeightUnit unit) {

        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid weight");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // Convert to base (kg)
    private double toBase() {
        return unit.toBase(value);
    }

    // Convert to another unit
    public UC9 convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = toBase();
        double result = targetUnit.fromBase(base);

        return new UC9(result, targetUnit);
    }

    // Add (default → first unit)
    public UC9 add(UC9 that) {
        return add(that, this.unit);
    }

    // Add (explicit target unit)
    public UC9 add(UC9 that, WeightUnit targetUnit) {

        if (that == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumBase = this.toBase() + that.toBase();
        double result = targetUnit.fromBase(sumBase);

        return new UC9(result, targetUnit);
    }

    // equals (IMPORTANT: base comparison)
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UC9 other = (UC9) obj;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}