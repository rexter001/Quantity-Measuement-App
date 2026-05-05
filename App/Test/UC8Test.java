package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC8;
import com.apps.quantitymeasurement.UC8.LengthUnit;

public class UC8Test {

    @Test
    public void testFeetEqualsInches() {
        assertTrue(new UC8(1, LengthUnit.FEET)
                .equals(new UC8(12, LengthUnit.INCHES)));
    }

    @Test
    public void testYardEqualsFeet() {
        assertTrue(new UC8(1, LengthUnit.YARDS)
                .equals(new UC8(3, LengthUnit.FEET)));
    }

    @Test
    public void testConvertFeetToInches() {
        UC8 result = new UC8(1, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.getValue(), 0.01);
    }

    @Test
    public void testConvertCmToInches() {
        UC8 result = new UC8(2.54, LengthUnit.CENTIMETERS)
                .convertTo(LengthUnit.INCHES);

        assertEquals(1.0, result.getValue(), 0.01);
    }

    @Test
    public void testAdditionSameUnit() {
        UC8 result = new UC8(1, LengthUnit.FEET)
                .add(new UC8(1, LengthUnit.FEET));

        assertTrue(result.equals(new UC8(2, LengthUnit.FEET)));
    }

    @Test
    public void testAdditionCrossUnit() {
        UC8 result = new UC8(1, LengthUnit.FEET)
                .add(new UC8(12, LengthUnit.INCHES));

        assertTrue(result.equals(new UC8(2, LengthUnit.FEET)));
    }

    @Test
    public void testAdditionTargetUnit() {
        UC8 result = new UC8(1, LengthUnit.FEET)
                .add(new UC8(12, LengthUnit.INCHES), LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), 0.01);
    }

    @Test
    public void testCommutative() {
        UC8 a = new UC8(1, LengthUnit.FEET);
        UC8 b = new UC8(12, LengthUnit.INCHES);

        assertTrue(a.add(b, LengthUnit.YARDS)
                .equals(b.add(a, LengthUnit.YARDS)));
    }

    @Test
    public void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC8(1, null);
        });
    }

    @Test
    public void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC8(Double.NaN, LengthUnit.FEET);
        });
    }
}