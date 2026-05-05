import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC3Test {

    @Test
    public void testFeetEquality() {
        UC3.Length l1 = new UC3.Length(1.0, UC3.LengthUnit.FEET);
        UC3.Length l2 = new UC3.Length(1.0, UC3.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {
        UC3.Length i1 = new UC3.Length(1.0, UC3.LengthUnit.INCHES);
        UC3.Length i2 = new UC3.Length(1.0, UC3.LengthUnit.INCHES);

        assertTrue(i1.equals(i2));
    }

    @Test
    public void testFeetInchesComparison() {
        UC3.Length feet = new UC3.Length(1.0, UC3.LengthUnit.FEET);
        UC3.Length inches = new UC3.Length(12.0, UC3.LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void testFeetInequality() {
        UC3.Length l1 = new UC3.Length(1.0, UC3.LengthUnit.FEET);
        UC3.Length l2 = new UC3.Length(2.0, UC3.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    public void testInchesInequality() {
        UC3.Length i1 = new UC3.Length(1.0, UC3.LengthUnit.INCHES);
        UC3.Length i2 = new UC3.Length(2.0, UC3.LengthUnit.INCHES);

        assertFalse(i1.equals(i2));
    }

    @Test
    public void testCrossUnitInequality() {
        UC3.Length feet = new UC3.Length(1.0, UC3.LengthUnit.FEET);
        UC3.Length inches = new UC3.Length(10.0, UC3.LengthUnit.INCHES);

        assertFalse(feet.equals(inches));
    }

    @Test
    public void testSameReference() {
        UC3.Length obj = new UC3.Length(1.0, UC3.LengthUnit.FEET);

        assertTrue(obj.equals(obj));
    }

    @Test
    public void testNullComparison() {
        UC3.Length obj = new UC3.Length(1.0, UC3.LengthUnit.FEET);

        assertFalse(obj.equals(null));
    }
}