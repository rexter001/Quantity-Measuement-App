public class QuantityMeasurementApp {

    // equality check
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // comparison using raw values
    public static boolean demonstrateLengthComparison(
            double v1, Length.LengthUnit u1,
            double v2, Length.LengthUnit u2) {

        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);

        return l1.equals(l2);
    }

    // UC5: conversion (method 1)
    public static Length demonstrateLengthConversion(
            double value,
            Length.LengthUnit from,
            Length.LengthUnit to) {

        return new Length(value, from).convertTo(to);
    }

    // UC5: conversion (method 2 - overloaded)
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit to) {

        return length.convertTo(to);
    }

    public static void main(String[] args) {

        System.out.println(demonstrateLengthConversion(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES));

        System.out.println(demonstrateLengthConversion(3.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.FEET));
    }
}