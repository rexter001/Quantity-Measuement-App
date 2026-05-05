package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC9;
import com.apps.quantitymeasurement.UC9.WeightUnit;

public class UC9Test {

    @Test
    public void kilogramEqualsGram() {
        assertTrue(new UC9(1, WeightUnit.KILOGRAM)
                .equals(new UC9(1000, WeightUnit.GRAM)));
    }

    @Test
    public void kilogramNotEqual() {
        assertFalse(new UC9(1, WeightUnit.KILOGRAM)
                .equals(new UC9(2, WeightUnit.KILOGRAM)));
    }

    @Test
    public void kilogramEqualsPound() {
        assertTrue(new UC9(1, WeightUnit.KILOGRAM)
                .equals(new UC9(2.20462, WeightUnit.POUND)));
    }

    @Test
    public void convertKgToGram() {
        UC9 result = new UC9(1, WeightUnit.KILOGRAM)
                .convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.getValue(), 0.01);
    }

    @Test
    public void convertPoundToKg() {
        UC9 result = new UC9(2.20462, WeightUnit.POUND)
                .convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    public void additionSameUnit() {
        UC9 result = new UC9(1, WeightUnit.KILOGRAM)
                .add(new UC9(2, WeightUnit.KILOGRAM));

        assertTrue(result.equals(new UC9(3, WeightUnit.KILOGRAM)));
    }

    @Test
    public void additionCrossUnit() {
        UC9 result = new UC9(1, WeightUnit.KILOGRAM)
                .add(new UC9(1000, WeightUnit.GRAM));

        assertTrue(result.equals(new UC9(2, WeightUnit.KILOGRAM)));
    }

    @Test
    public void additionWithTargetUnit() {
        UC9 result = new UC9(1, WeightUnit.KILOGRAM)
                .add(new UC9(1000, WeightUnit.GRAM), WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), 0.01);
    }

    @Test
    public void commutativeProperty() {
        UC9 a = new UC9(1, WeightUnit.KILOGRAM);
        UC9 b = new UC9(1000, WeightUnit.GRAM);

        assertTrue(a.add(b, WeightUnit.KILOGRAM)
                .equals(b.add(a, WeightUnit.KILOGRAM)));
    }

    @Test
    public void nullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC9(1, null);
        });
    }

    @Test
    public void invalidValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC9(Double.NaN, WeightUnit.KILOGRAM);
        });
    }

    @Test
    public void zeroEquality() {
        assertTrue(new UC9(0, WeightUnit.KILOGRAM)
                .equals(new UC9(0, WeightUnit.GRAM)));
    }

    @Test
    public void negativeValues() {
        assertTrue(new UC9(-1, WeightUnit.KILOGRAM)
                .equals(new UC9(-1000, WeightUnit.GRAM)));
    }
}