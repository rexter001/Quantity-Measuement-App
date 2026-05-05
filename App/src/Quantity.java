package com.apps.quantitymeasurement;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
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
        return unit.convertToBaseUnit(value);
    }

    public Quantity<U> convertTo(U targetUnit) {
        double base = this.toBase();
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<U>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        double sum = this.toBase() + other.toBase();
        double result = unit.convertFromBaseUnit(sum);
        return new Quantity<U>(result, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double sum = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBaseUnit(sum);
        return new Quantity<U>(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        return Math.abs(this.toBase() - other.toBase()) < 0.01;
    }
}