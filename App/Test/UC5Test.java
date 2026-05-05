import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC5Test {

    private static final double EPSILON = 0.0001;

    // ✅ Basic conversions
    @Test
    public void testFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        assertEquals(12.0, Length.convert(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES), EPSILON);
    }

    @Test
    public void testInchesToFeet() {
        double result = Length.convert(24.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testYardsToInches() {
        double result = Length.convert(1.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.INCHES);

        assertEquals(36.0, result, EPSILON);
    }

    @Test
    public void testInchesToYards() {
        double result = Length.convert(72.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    public void testCentimeterToInches() {
        double result = Length.convert(2.54,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES);

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    public void testFeetToYards() {
        double result = Length.convert(6.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.YARDS);

        assertEquals(2.0, result, EPSILON);
    }

    // ✅ Zero & Negative
    @Test
    public void testZeroConversion() {
        double result = Length.convert(0.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(0.0, result, EPSILON);
    }

    @Test
    public void testNegativeConversion() {
        double result = Length.convert(-1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        assertEquals(-12.0, result, EPSILON);
    }

    // ✅ Same unit
    @Test
    public void testSameUnitConversion() {
        double result = Length.convert(5.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.FEET);

        assertEquals(5.0, result, EPSILON);
    }

    // ✅ Round-trip test
    @Test
    public void testRoundTripConversion() {
        double original = 5.0;

        double toInches = Length.convert(original,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        double backToFeet = Length.convert(toInches,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.FEET);

        assertEquals(original, backToFeet, EPSILON);
    }

    // ✅ Overloaded method test
    @Test
    public void testOverloadedConversionMethod() {
        Length length = new Length(2.0, Length.LengthUnit.YARDS);

        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(length, Length.LengthUnit.INCHES);

        assertTrue(result.equals(new Length(72.0, Length.LengthUnit.INCHES)));
    }

    // ✅ Equality check
    @Test
    public void testEqualityAcrossUnits() {
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    // ✅ Invalid input tests
    @Test
    public void testNullUnitThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(1.0, null, Length.LengthUnit.FEET);
        });
    }

    @Test
    public void testInvalidValueThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            Length.convert(Double.NaN,
                    Length.LengthUnit.FEET,
                    Length.LengthUnit.INCHES);
        });
    }
}