package com.apps.quantitymeasurement;

/**
 * UC10 - Generic Quantity Class with Measurable Interface
 */

// 🔥 Common interface for ALL units (Length, Weight, future types)
interface Measurable {
    double toBase(double value);        // convert → base unit
    double fromBase(double baseValue);  // convert ← base unit
}

// ===================== LENGTH =====================
enum LengthUnit implements Measurable {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double factor;

    LengthUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double toBase(double value) {
        return value * factor;
    }

    @Override
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }
}

// ===================== WEIGHT =====================
enum WeightUnit implements Measurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double toBase(double value) {
        return value * factor;
    }

    @Override
    public double fromBase(double baseValue) {
        return baseValue / factor;
    }
}

// ===================== GENERIC QUANTITY =====================
public class UC10<U extends Measurable> {

    private final double value;
    private final U unit;

    public UC10(double value, U unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.toBase(value);
    }

    // Convert
    public UC10<U> convertTo(U targetUnit) {
        double base = toBase();
        double result = targetUnit.fromBase(base);
        return new UC10<>(result, targetUnit);
    }

    // Add (same unit result)
    public UC10<U> add(UC10<U> other) {
        return add(other, this.unit);
    }

    // Add (target unit)
    public UC10<U> add(UC10<U> other, U targetUnit) {
        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.fromBase(sumBase);
        return new UC10<>(result, targetUnit);
    }

    // Equality
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        UC10<?> other = (UC10<?>) obj;

        // ❗ prevent cross-category comparison
        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }
}