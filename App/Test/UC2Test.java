import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC2.Feet;
import com.apps.quantitymeasurement.UC2.Inches;

/**
 * UC2Test - Unit Test Class for Feet and Inches Measurement Equality
 */

public class UC2Test {

    // ---------------- FEET TEST CASES ----------------

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);

        assertFalse(feet1.equals(feet2));
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(1.0);

        assertFalse(feet1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet1 = new Feet(1.0);
        String value = "1.0";

        assertFalse(feet1.equals(value));
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet1 = new Feet(1.0);

        assertTrue(feet1.equals(feet1));
    }

    // ---------------- INCHES TEST CASES ----------------

    @Test
    public void testInchesEquality_SameValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);

        assertTrue(inch1.equals(inch2));
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(2.0);

        assertFalse(inch1.equals(inch2));
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inch1 = new Inches(1.0);

        assertFalse(inch1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inch1 = new Inches(1.0);
        String value = "1.0";

        assertFalse(inch1.equals(value));
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inch1 = new Inches(1.0);

        assertTrue(inch1.equals(inch1));
    }
}