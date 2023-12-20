package ua.nure.cpp.sivenko.practice1.task;

import java.util.Locale;

import static java.lang.Math.*;

public class Part1 {
    public static void main(String[] args) {
        if (args.length < 2)
            throw new IllegalArgumentException("Two decimal numbers must be passed as arguments");

        final double a = Double.parseDouble(args[0]);
        final double c = Double.parseDouble(args[1]);

        System.out.printf(Locale.US, "\nFunction Calculation for initial values a = %.1f, c = %.1f:\n", a, c);
        calculateFunction(a, c);
    }

    private static void calculateFunction(double a, double c) {
        for (double d = 2; d <= 15; d++) {
            for (double t = 0; t <= 5; t += 0.5) {
                for (double m = -2; m <= 2; m += 0.41) {
                    double b = calculateB(a, c, m);
                    a = calculateA(d, t);
                    c = calculateC(a, d, b, m);

                    displayValues(d, t, m, b, a, c);
                }
            }
        }
    }

    private static double calculateB(double a, double c, double m) {
        return cos(a) * cos(2 * c) - sin(PI / 4 + m) * sin(PI / 4 + 4 * m)
                + sin(3 * PI / 4 + 4 * a) * cos(7 * PI / 4 - 5 * c);
    }

    private static double calculateA(double d, double t) {
        if (d > t && t > 1)
            return Math.log(t + d * d);
        if (t > 1)
            return Math.sqrt(t * d);

        return t * t * d;
    }

    private static double calculateC(double a, double d, double b, double m) {
        return Math.pow(tan(a), 3) - 1 + 1 / Math.pow(cos(d), 2) - 3 * (1 / tan(PI / 2 - Math.pow(b, 3))) * 3 * m;
    }

    private static void displayValues(double d, double t, double m, double b, double a, double c) {
        System.out.printf(Locale.US, "d = %.1f, t = %.1f, m = %f, b = %f, a = %f, c = %f\n", d, t, m, b, a, c);
    }
}
