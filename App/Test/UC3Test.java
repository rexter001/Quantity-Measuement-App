

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.UC3.Length;
import com.apps.quantitymeasurement.UC3.LengthUnit;

/**
 * UC3Test - Unit Test Class
 */

public class UC3Test {

    @Test
    public void testFeetEquality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(length1.equals(length2));
    }

    @Test
    public void testInchesEquality() {
        Length inches1 = new Length(1.0, LengthUnit.INCHES);
        Length inches2 = new Length(1.0, LengthUnit.INCHES);

        assertTrue(inches1.equals(inches2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);

        assertFalse(length1.equals(length2));
    }

    @Test
    public void testInchesInequality() {
        Length inches1 = new Length(1.0, LengthUnit.INCHES);
        Length inches2 = new Length(2.0, LengthUnit.INCHES);

        assertFalse(inches1.equals(inches2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = new Length(10.0, LengthUnit.INCHES);

        assertFalse(feet.equals(inches));
    }

    @Test
    public void testSameReference() {
        Length length = new Length(1.0, LengthUnit.FEET);

        assertTrue(length.equals(length));
    }

    @Test
    public void testNullComparison() {
        Length length = new Length(1.0, LengthUnit.FEET);

        assertFalse(length.equals(null));
    }
}