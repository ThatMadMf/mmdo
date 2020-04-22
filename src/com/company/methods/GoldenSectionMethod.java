package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class GoldenSectionMethod extends Method implements Solvable {

    public GoldenSectionMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public double solve() {
        double u = calculateU(a, b);
        double v = a + b - u;

        double fu = calculateFunc(u);
        double fv = calculateFunc(v);

        while (!isSolved(a, b, eps)) {
            if (fu <= fv) {
                b = v;
                v = u;

                fv = fu;
                u = a + b - v;

                fu = calculateFunc(u);
            } else {
                a = u;
                u = v;

                fu = fv;
                v = a + b - u;

                fv = calculateFunc(v);
            }

            if (u > v) {
                u = calculateU(a, b);
                v = a + b - u;
                fv = calculateFunc(v);
            }

            iterations++;
        }

        return (a + b) / 2;
    }

    @Override
    public int getIterationCount() {
        return iterations;
    }

    @Override
    public int getFunctionCalculationCount() {
        return functionCalculations;
    }

    private double calculateU(double a, double b) {
        return a + (3 - Math.sqrt(5)) / 2 * (b - a);
    }

    private boolean isSolved(double a, double b, double eps) {
        return (b - a) < eps;
    }
}
