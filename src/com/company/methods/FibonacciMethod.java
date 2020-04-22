package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class FibonacciMethod extends Method implements Solvable {

    public FibonacciMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public double solve() {
        return 0;
    }

    @Override
    public int getIterationCount() {
        return iterations;
    }

    @Override
    public int getFunctionCalculationCount() {
        return functionCalculations;
    }

    private int calculateN(double x) {
        throw new RuntimeException("Not implemented");
    }
}
