import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC4Test {

    @Test
    public void yardEqual36Inches() {
        UC4.Length yard = new UC4.Length(1.0, UC4.LengthUnit.YARDS);
        UC4.Length inches = new UC4.Length(36.0, UC4.LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEqual39Point3701Inches() {
        UC4.Length cm = new UC4.Length(100.0, UC4.LengthUnit.CENTIMETERS);
        UC4.Length inches = new UC4.Length(39.3701, UC4.LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        UC4.Length feet = new UC4.Length(3.0, UC4.LengthUnit.FEET);
        UC4.Length yard = new UC4.Length(1.0, UC4.LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtyPoint48CmEqualOneFoot() {
        UC4.Length cm = new UC4.Length(30.48, UC4.LengthUnit.CENTIMETERS);
        UC4.Length foot = new UC4.Length(1.0, UC4.LengthUnit.FEET);

        assertTrue(cm.equals(foot));
    }

    @Test
    public void yardNotEqualToInches() {
        UC4.Length yard = new UC4.Length(1.0, UC4.LengthUnit.YARDS);
        UC4.Length inches = new UC4.Length(20.0, UC4.LengthUnit.INCHES);

        assertFalse(yard.equals(inches));
    }

    @Test
    public void sameReference() {
        UC4.Length obj = new UC4.Length(1.0, UC4.LengthUnit.YARDS);
        assertTrue(obj.equals(obj));
    }

    @Test
    public void nullCheck() {
        UC4.Length obj = new UC4.Length(1.0, UC4.LengthUnit.YARDS);
        assertFalse(obj.equals(null));
    }

    @Test
    public void transitiveProperty() {
        UC4.Length a = new UC4.Length(1.0, UC4.LengthUnit.YARDS);
        UC4.Length b = new UC4.Length(3.0, UC4.LengthUnit.FEET);
        UC4.Length c = new UC4.Length(36.0, UC4.LengthUnit.INCHES);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        UC4.Length a = new UC4.Length(1.0, UC4.LengthUnit.YARDS);
        UC4.Length b = new UC4.Length(2.0, UC4.LengthUnit.YARDS);

        assertFalse(a.equals(b));
    }

    @Test
    public void crossUnitEqualityMethod() {
        boolean result = UC4.demonstrateLengthComparison(
                1.0, UC4.LengthUnit.YARDS,
                3.0, UC4.LengthUnit.FEET
        );
        assertTrue(result);
    }
}