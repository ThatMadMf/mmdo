package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class DichotomyMethod extends Method implements Solvable {

    public DichotomyMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public double solve() {
        double gamma = eps / 3;

        while (!isSolved(a, b, eps)) {
            iterations++;

            double x1 = (a + b - gamma) / 2;
            double x2 = (a + b + gamma) / 2;

            double f1 = calculateFunc(x1);
            double f2 = calculateFunc(x2);

            if (f1 <= f2) {
                b = x2;
            } else {
                a = x1;
            }
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

    private boolean isSolved(double a, double b, double eps) {
        return (b - a) < eps;
    }
}
