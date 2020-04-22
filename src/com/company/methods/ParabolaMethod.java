package com.company.methods;

import com.company.Function;
import com.company.Solvable;

public class ParabolaMethod extends Method implements Solvable {

    public ParabolaMethod(Function func, int a, int b, double eps) {
        super(func, a, b, eps);
    }

    @Override
    public double solve() {

        return 0;
    }

    @Override
    public int getIterationCount() {
        return 0;
    }

    @Override
    public int getFunctionCalculationCount() {
        return 0;
    }


}
