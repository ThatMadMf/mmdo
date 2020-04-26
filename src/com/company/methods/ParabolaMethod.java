package com.company.methods;

import com.company.Function;
import com.company.Solvable;

import static java.lang.Math.abs;

public class ParabolaMethod extends Method implements Solvable {

    private final double c;

    public ParabolaMethod(Function func, int a, int b, double eps, double c) {
        super(func, a, b, eps);
        this.c = c;
    }

    public ParabolaMethod(Function func, int a, int b, double eps) {
        this(func, a, b, eps, (a + b) / 2.0);
    }

    @Override
    public ResultEntry solve() {

        LocalizationMethod localizationMethod = new LocalizationMethod(func, eps, c, 0.01);
        localizationMethod.solve();
        Triple triple = localizationMethod.getTriple();

        double x0 = triple.getX0();
        double x1 = triple.getX1();
        double x2 = triple.getX2();

        double f0 = calculateFunc(x0);
        double f1 = calculateFunc(x1);
        double f2 = calculateFunc(x2);

        double x = calculateX(x0, x1, x2, f0, f1, f2);
        double fx = calculateFunc(x);

        while (isSolved(x, x1, x2)) {
            double x3 = 0;
            double f3 = 0;

            if (x < x1) {

                x3 = x2;
                f3 = f2;
                x2 = x1;
                f2 = f1;
                x1 = x;
                f1 = fx;
            } else if (x > x1) {

                x3 = x2;
                f3 = f2;
                x2 = x;
                f2 = fx;
            }

            if (f1 > f2) {

                x0 = x1;
                f0 = f1;
                x1 = x2;
                f1 = f2;
                x2 = x3;
                f2 = f3;
            }

            x = calculateX(x0, x1, x2, f0, f1, f2);
            fx = calculateFunc(x);

            iterations++;
        }

        return new ResultEntry(
                x,
                calculateFunc(x),
                iterations,
                functionCalculations
        );
    }

    @Override
    public double getEpsilon() {
        return getEps();
    }

    private boolean isSolved(double x, double x1, double x2) {
        return abs(x1 - x) >= eps && abs(x2 - x) >= eps;
    }

    private double calculateX(double x0, double x1, double x2, double f0, double f1, double f2) {
        return (x0 + x1) / 2 + (f1 - f0) * (x2 - x0) * (x2 - x1) /
                (2 * ((f1 - f0) * (x2 - x0) - (f2 - f0) * (x1 - x0)));
    }
}
