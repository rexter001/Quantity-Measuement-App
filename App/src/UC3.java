package com.apps.quantitymeasurement;

/**
 * UC3 - Generic Quantity Class for DRY Principle
 *
 * This class removes duplication between Feet and Inches classes
 * by using one generic Length class with LengthUnit enum.
 */

public class UC3 {

    /**
     * Enum for supported length units
     * All conversion factors are based on inches
     */
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    /**
     * Generic Length class
     */
    public static class Length {
        private double value;
        private LengthUnit unit;

        // Constructor
        public Length(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        /**
         * Convert value to base unit (inches)
         */
        private double convertToBaseUnit() {
            return value * unit.getConversionFactor();
        }

        /**
         * Compare two Length objects
         */
        public boolean compare(Length thatLength) {
            return Double.compare(
                    this.convertToBaseUnit(),
                    thatLength.convertToBaseUnit()
            ) == 0;
        }

        /**
         * Override equals()
         */
        @Override
        public boolean equals(Object o) {

            // Same reference check
            if (this == o) {
                return true;
            }

            // Null check and type check
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Length that = (Length) o;

            return this.compare(that);
        }
    }

    /**
     * Feet equality check
     */
    public static void demonstrateFeetEquality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        System.out.println(
                "Feet Equality: " + length1.equals(length2)
        );
    }

    /**
     * Inches equality check
     */
    public static void demonstrateInchesEquality() {
        Length length1 = new Length(1.0, LengthUnit.INCHES);
        Length length2 = new Length(1.0, LengthUnit.INCHES);

        System.out.println(
                "Inches Equality: " + length1.equals(length2)
        );
    }

    /**
     * Feet and Inches comparison
     */
    public static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println(
                "Feet to Inches Equality: " + length1.equals(length2)
        );
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}