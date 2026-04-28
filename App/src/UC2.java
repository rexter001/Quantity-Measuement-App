package com.apps.quantitymeasurement;

/**
 * UC2 - Feet and Inches measurement equality
 *
 * This class checks equality of two numerical values
 * measured in Feet and Inches separately.
 */

public class UC2 {

    // Inner class to represent Feet measurement
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj) {
                return true;
            }

            // Null check and type check
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Inner class to represent Inches measurement
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Same reference check
            if (this == obj) {
                return true;
            }

            // Null check and type check
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Static method for Feet equality check
    public static void demonstrateFeetEquality() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        boolean result = feet1.equals(feet2);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Static method for Inches equality check
    public static void demonstrateInchesEquality() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);

        boolean result = inch1.equals(inch2);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    // Main method
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}