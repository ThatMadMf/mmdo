package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class DichotomyMethod extends Method implements Solvable {

    public DichotomyMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public ResultEntry solve() {
        double delta = eps / 3;

        while (!isSolved(a, b, eps)) {
            iterations++;

            double x1 = (a + b - delta) / 2;
            double x2 = (a + b + delta) / 2;

            double f1 = calculateFunc(x1);
            double f2 = calculateFunc(x2);

            if (f1 <= f2) {
                b = x2;
            } else {
                a = x1;
            }
        }

        double solution = (a + b) / 2;

        return new ResultEntry(
                solution,
                calculateFunc(solution),
                iterations,
                functionCalculations
        );
    }

    @Override
    public double getEpsilon() {
        return getEps();
    }


    private boolean isSolved(double a, double b, double eps) {
        return (b - a) < eps;
    }
}
