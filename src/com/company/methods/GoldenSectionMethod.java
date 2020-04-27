package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class GoldenSectionMethod extends Method implements Solvable {

    public GoldenSectionMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public ResultEntry solve() {
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

        double solution = (a + b) / 2;

        return generateResult(solution);
    }

    @Override
    public double getEpsilon() {
        return getEps();
    }


    private double calculateU(double a, double b) {
        return a + (3 - Math.sqrt(5)) / 2 * (b - a);
    }

    private boolean isSolved(double a, double b, double eps) {
        return (b - a) < eps;
    }
}
