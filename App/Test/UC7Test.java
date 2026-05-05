package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC7;
import com.apps.quantitymeasurement.UC7.LengthUnit;

public class UC7Test {

    @Test
    public void testAddition_TargetFeet() {
        UC7 a = new UC7(1.0, LengthUnit.FEET);
        UC7 b = new UC7(12.0, LengthUnit.INCHES);

        UC7 result = a.add(b, LengthUnit.FEET);

        assertTrue(result.equals(new UC7(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testAddition_TargetInches() {
        UC7 a = new UC7(1.0, LengthUnit.FEET);
        UC7 b = new UC7(12.0, LengthUnit.INCHES);

        UC7 result = a.add(b, LengthUnit.INCHES);

        assertTrue(result.equals(new UC7(24.0, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_TargetYards() {
        UC7 a = new UC7(1.0, LengthUnit.FEET);
        UC7 b = new UC7(12.0, LengthUnit.INCHES);

        UC7 result = a.add(b, LengthUnit.YARDS);

        assertEquals(0.666, result.getValue(), 0.01); // tolerance
    }

    @Test
    public void testAddition_TargetCentimeters() {
        UC7 a = new UC7(1.0, LengthUnit.INCHES);
        UC7 b = new UC7(1.0, LengthUnit.INCHES);

        UC7 result = a.add(b, LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), 0.01);
    }

    @Test
    public void testCommutativeProperty() {
        UC7 a = new UC7(1.0, LengthUnit.FEET);
        UC7 b = new UC7(12.0, LengthUnit.INCHES);

        assertTrue(
                a.add(b, LengthUnit.YARDS)
                        .equals(b.add(a, LengthUnit.YARDS))
        );
    }

    @Test
    public void testNullTargetUnit() {
        UC7 a = new UC7(1.0, LengthUnit.FEET);
        UC7 b = new UC7(12.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () -> {
            a.add(b, null);
        });
    }

    @Test
    public void testNegativeValues() {
        UC7 a = new UC7(5.0, LengthUnit.FEET);
        UC7 b = new UC7(-2.0, LengthUnit.FEET);

        UC7 result = a.add(b, LengthUnit.INCHES);

        assertTrue(result.equals(new UC7(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void testZeroCase() {
        UC7 a = new UC7(5.0, LengthUnit.FEET);
        UC7 b = new UC7(0.0, LengthUnit.INCHES);

        UC7 result = a.add(b, LengthUnit.YARDS);

        assertEquals(1.666, result.getValue(), 0.01);
    }
}