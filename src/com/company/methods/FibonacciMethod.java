package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class FibonacciMethod extends Method implements Solvable {

    public FibonacciMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public ResultEntry solve() {
        return null;
    }

    private int calculateN(double x) {
        throw new RuntimeException("Not implemented");
    }
}
