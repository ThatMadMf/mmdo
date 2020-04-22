package com.company.methods;

import com.company.Function;

public class Method {
    protected final Function func;
    protected final double eps;

    protected double a;
    protected double b;

    protected int iterations;
    protected int functionCalculations;

    public Method(Function func, int a, int b, double eps) {
        this.func = func;
        this.a = a;
        this.b = b;
        this.eps = eps;
        iterations = 0;
        functionCalculations = 0;
    }

    protected double calculateFunc(double x) {
        functionCalculations++;
        return func.calculate(x);
    }
}
