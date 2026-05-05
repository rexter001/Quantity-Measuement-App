package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC6;
import com.apps.quantitymeasurement.UC6.LengthUnit;

public class UC6Test {

    // Same unit
    @Test
    public void testFeetPlusFeet() {
        UC6 a = new UC6(1.0, LengthUnit.FEET);
        UC6 b = new UC6(2.0, LengthUnit.FEET);

        UC6 result = a.add(b);

        assertTrue(result.equals(new UC6(3.0, LengthUnit.FEET)));
    }

    // Cross unit
    @Test
    public void testFeetPlusInches() {
        UC6 feet = new UC6(1.0, LengthUnit.FEET);
        UC6 inches = new UC6(12.0, LengthUnit.INCHES);

        UC6 result = feet.add(inches);

        assertTrue(result.equals(new UC6(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesPlusFeet() {
        UC6 inches = new UC6(12.0, LengthUnit.INCHES);
        UC6 feet = new UC6(1.0, LengthUnit.FEET);

        UC6 result = inches.add(feet);

        assertTrue(result.equals(new UC6(24.0, LengthUnit.INCHES)));
    }

    @Test
    public void testYardPlusFeet() {
        UC6 yard = new UC6(1.0, LengthUnit.YARDS);
        UC6 feet = new UC6(3.0, LengthUnit.FEET);

        UC6 result = yard.add(feet);

        assertTrue(result.equals(new UC6(2.0, LengthUnit.YARDS)));
    }

    // Zero
    @Test
    public void testZeroAddition() {
        UC6 a = new UC6(5.0, LengthUnit.FEET);
        UC6 zero = new UC6(0.0, LengthUnit.INCHES);

        assertTrue(a.add(zero).equals(a));
    }

    // Negative
    @Test
    public void testNegativeAddition() {
        UC6 a = new UC6(5.0, LengthUnit.FEET);
        UC6 b = new UC6(-2.0, LengthUnit.FEET);

        UC6 result = a.add(b);

        assertTrue(result.equals(new UC6(3.0, LengthUnit.FEET)));
    }

    // Null
    @Test
    public void testNullAddition() {
        UC6 a = new UC6(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.add(null);
        });
    }

    // Commutative
    @Test
    public void testCommutativeProperty() {
        UC6 a = new UC6(1.0, LengthUnit.FEET);
        UC6 b = new UC6(12.0, LengthUnit.INCHES);

        assertTrue(a.add(b).equals(b.add(a)));
    }
}