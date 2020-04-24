package com.company.methods;

import com.company.Function;
import com.company.PreciseSolutionFailedException;
import com.company.Solvable;

public class LocalizationMethod extends Method implements Solvable {

    private double x0;
    private double h;

    public LocalizationMethod(Function func, double eps, double x0, double h) {
        super(func, eps);
        this.x0 = x0;
        this.h = h;
    }

    @Override
    public ResultEntry solve() {
        double f1 = calculateFunc(x0);
        double f2 = 0;
        double x2 = 0;

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
        } while (f1 < f2 || Math.abs(h) > eps);

        if(Math.abs(h) > eps) {
            double x1 = 0;

            while (f1 > f2) {
                x1 = x2;

                x2 = x1 + h;
                f2 = calculateFunc(x2);

                iterations++;
            }

            double a = 0;
            double b = 0;
            if(h > 0) {

                a = x1 - h;
                b = x2;
            } else {

                a = x2;
                b = x1 - h;
            }

            throw new PreciseSolutionFailedException("Failed to solve precisely", a, b);
        } else {

            return new ResultEntry(
                    x0,
                    calculateFunc(x0),
                    iterations,
                    functionCalculations
            );
        }
    }
}
