package com.apps.quantitymeasurement;
import com.apps.quantitymeasurement.LengthUnit;
import com.apps.quantitymeasurement.WeightUnit;
import com.apps.quantitymeasurement.UC10;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC10Test {

    // ---------- LENGTH TESTS ----------
    @Test
    public void feetEqualsInches() {
        com.apps.quantitymeasurement.UC10<com.apps.quantitymeasurement.LengthUnit> a = new com.apps.quantitymeasurement.UC10<>(1, com.apps.quantitymeasurement.LengthUnit.FEET);
        com.apps.quantitymeasurement.UC10<com.apps.quantitymeasurement.LengthUnit> b = new com.apps.quantitymeasurement.UC10<>(12, com.apps.quantitymeasurement.LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    public void convertFeetToInches() {
        UC10<LengthUnit> result =
                new UC10<>(1, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }

    @Test
    public void addFeetAndInches() {
        UC10<LengthUnit> result =
                new UC10<>(1, LengthUnit.FEET)
                        .add(new UC10<>(12, LengthUnit.INCHES));

        assertTrue(result.equals(new UC10<>(2, LengthUnit.FEET)));
    }

    // ---------- WEIGHT TESTS ----------
    @Test
    public void kgEqualsGram() {
        UC10<WeightUnit> a = new UC10<>(1, WeightUnit.KILOGRAM);
        UC10<WeightUnit> b = new UC10<>(1000, WeightUnit.GRAM);

        assertTrue(a.equals(b));
    }

    @Test
    public void convertKgToGram() {
        UC10<WeightUnit> result =
                new UC10<>(1, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    @Test
    public void addKgAndGram() {
        UC10<WeightUnit> result =
                new UC10<>(1, WeightUnit.KILOGRAM)
                        .add(new UC10<>(1000, WeightUnit.GRAM));

        assertTrue(result.equals(new UC10<>(2, WeightUnit.KILOGRAM)));
    }

    // ---------- CROSS CATEGORY ----------
    @Test
    public void lengthNotEqualWeight() {
        UC10<com.apps.quantitymeasurement.LengthUnit> length =
                new UC10<>(1, com.apps.quantitymeasurement.LengthUnit.FEET);

        com.apps.quantitymeasurement.UC10<com.apps.quantitymeasurement.WeightUnit> weight =
                new com.apps.quantitymeasurement.UC10<>(1, com.apps.quantitymeasurement.WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    // ---------- EDGE CASES ----------
    @Test
    public void nullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new com.apps.quantitymeasurement.UC10<>(1, null));
    }

    @Test
    public void invalidValueThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new com.apps.quantitymeasurement.UC10<>(Double.NaN, com.apps.quantitymeasurement.LengthUnit.FEET));
    }
}