public class UC1 {

    // Inner class to represent Feet measurement
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals() method
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

            // Type casting
            Feet feet = (Feet) obj;

            // Compare double values using Double.compare()
            return Double.compare(this.value, feet.value) == 0;
        }
    }

    // Main method
    public static void main(String[] args) {

        Feet firstValue = new Feet(1.0);
        Feet secondValue = new Feet(1.0);

        boolean result = firstValue.equals(secondValue);

        System.out.println("Equal (" + result + ")");
    }
}