
package com.company.methods;

import com.company.Function;

import static java.lang.StrictMath.abs;

public class LocalizationMethod extends Method {

    private double x0;
    private double h;
    private Triple triple;

    public LocalizationMethod(Function func, double eps, double x0, double h) {
        super(func, eps);
        this.x0 = x0;
        this.h = h;
    }

    public ResultEntry solve() {
        double f1 = calculateFunc(x0);
        double x2;
        double f2;

        do {
            h /= 2;

            x2 = x0 + h;
            f2 = calculateFunc(x2);

            if (f1 <= f2) {
                h *= -1;
                x2 = x0 + h;
                f2 = calculateFunc(x2);
            }

            iterations++;
        } while (!(f1 > f2 || abs(h) < eps));

        double x1;

        do {
            x1 = x2;
            f1 = f2;

            x2 = x1 + h;
            f2 = calculateFunc(x2);

            iterations++;
        } while (!(f1 < f2));

        double a;
        double b;

        if (h > 0) {

            a = x1 - h;
            b = x2;
        } else {

            a = x2;
            b = x1 - h;
        }

        triple = new Triple(x0, x1, x2);

        if (abs(h) > eps) {
            System.out.println("a = " + a + "\tb = " + b + "\n");
            return null;
        } else {
            return new ResultEntry(
                    x0,
                    calculateFunc(x0),
                    iterations,
                    functionCalculations
            );
        }
    }

    public Triple getTriple() {
        return triple;
    }
}