package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class FibonacciMethod extends Method implements Solvable {

    private final int n;

    public FibonacciMethod(Function func, int a, int b, double eps, int n) {
        super(func, a, b, eps);
        this.n = n;
    }

    public FibonacciMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
        this.n = getValidN();
    }

    @Override
    public ResultEntry solve() {

        double u = a + calculateFibonacci(n) / calculateFibonacci(n + 2) * (b - a);
        double v = a + b - u;

        double fu = calculateFunc(u);
        double fv = calculateFunc(v);

        for (int i = 1; i <= n; i++) {

            if (fu < fv) {

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
                u = a + calculateFibonacci(n - i + 1) / calculateFibonacci(n - i + 3) * (b - a);
                v = a + b - u;

                fu = calculateFunc(u);
                fv = calculateFunc(v);
            }

            iterations++;
        }

        double solution = (a + b) / 2;

        return new ResultEntry(
                solution,
                calculateFunc(solution),
                iterations,
                functionCalculations
        );
    }

    private boolean IsValidN() {
        return (b - a) / calculateFibonacci(n + 2) < eps;
    }

    private int getValidN() {
        int n = 1;
        while ((b - a) / calculateFibonacci(n + 2) > eps) {
            n++;
        }
        return n;
    }

    private double calculateFibonacci(int n) {

        if (n <= 1) {
            return 1;
        }

        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
}
