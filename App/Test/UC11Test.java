package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11Test {

    private static final double EPSILON = 0.01;

    // ---------- EQUALITY TESTS ----------

    @Test
    public void litreEqualsMillilitre() {
        Quantity<UC11> a = new Quantity<UC11>(1.0, UC11.LITRE);
        Quantity<UC11> b = new Quantity<UC11>(1000.0, UC11.MILLILITRE);

        assertTrue(a.equals(b));
    }

    @Test
    public void litreEqualsGallon() {
        Quantity<UC11> litre = new Quantity<UC11>(3.78541, UC11.LITRE);
        Quantity<UC11> gallon = new Quantity<UC11>(1.0, UC11.GALLON);

        assertTrue(litre.equals(gallon));
    }

    @Test
    public void differentVolumesNotEqual() {
        Quantity<UC11> a = new Quantity<UC11>(1.0, UC11.LITRE);
        Quantity<UC11> b = new Quantity<UC11>(2.0, UC11.LITRE);

        assertFalse(a.equals(b));
    }

    // ---------- CONVERSION TESTS ----------

    @Test
    public void litreToMillilitre() {
        Quantity<UC11> result =
                new Quantity<UC11>(1.0, UC11.LITRE)
                        .convertTo(UC11.MILLILITRE);

        assertEquals(1000.0, result.getValue(), EPSILON);
    }

    @Test
    public void gallonToLitre() {
        Quantity<UC11> result =
                new Quantity<UC11>(1.0, UC11.GALLON)
                        .convertTo(UC11.LITRE);

        assertEquals(3.79, result.getValue(), EPSILON); // rounded
    }

    @Test
    public void millilitreToGallon() {
        Quantity<UC11> result =
                new Quantity<UC11>(1000.0, UC11.MILLILITRE)
                        .convertTo(UC11.GALLON);

        assertEquals(0.26, result.getValue(), EPSILON);
    }

    // ---------- ADDITION TESTS ----------

    @Test
    public void addLitreAndMillilitre() {
        Quantity<UC11> result =
                new Quantity<UC11>(1.0, UC11.LITRE)
                        .add(new Quantity<UC11>(1000.0, UC11.MILLILITRE));

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(UC11.LITRE, result.getUnit());
    }

    @Test
    public void addWithTargetUnit() {
        Quantity<UC11> result =
                new Quantity<UC11>(1.0, UC11.LITRE)
                        .add(
                                new Quantity<UC11>(1000.0, UC11.MILLILITRE),
                                UC11.MILLILITRE
                        );

        assertEquals(2000.0, result.getValue(), EPSILON);
        assertEquals(UC11.MILLILITRE, result.getUnit());
    }

    // ---------- EDGE CASES ----------

    @Test
    public void zeroVolume() {
        Quantity<UC11> a = new Quantity<UC11>(0.0, UC11.LITRE);
        Quantity<UC11> b = new Quantity<UC11>(0.0, UC11.MILLILITRE);

        assertTrue(a.equals(b));
    }

    @Test
    public void negativeVolume() {
        Quantity<UC11> a = new Quantity<UC11>(-1.0, UC11.LITRE);
        Quantity<UC11> b = new Quantity<UC11>(-1000.0, UC11.MILLILITRE);

        assertTrue(a.equals(b));
    }
}