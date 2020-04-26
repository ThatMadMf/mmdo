package com.company;

import com.company.methods.*;

import java.util.ArrayList;
import java.util.List;

public class MethodFactory {

    public static Solvable getMethod(MethodEnum method, Function func, int a, int b, double eps) {
        switch (method) {
            case DICHOTOMY:
                return new DichotomyMethod(func, a, b, eps);
            case GOLDEN_SECTION:
                return new GoldenSectionMethod(func, a, b, eps);
            case FIBONACCI:
                return new FibonacciMethod(func, a, b, eps);
            case PARABOLA:
                return new ParabolaMethod(func, a, b, eps);
            default:
                throw new IllegalArgumentException("Unsupported method");
        }
    }

    public static List<Solvable> getAllMethods(Function function, int a, int b) {
        List<Solvable> result = new ArrayList<>();

        result.add(getMethod(MethodEnum.DICHOTOMY, function, a, b, 0.01));
        result.add(getMethod(MethodEnum.DICHOTOMY, function, a, b, 0.0001));
        result.add(getMethod(MethodEnum.DICHOTOMY, function, a, b, 0.00000001));

        result.add(getMethod(MethodEnum.GOLDEN_SECTION, function, a, b, 0.01));
        result.add(getMethod(MethodEnum.GOLDEN_SECTION, function, a, b, 0.0001));
        result.add(getMethod(MethodEnum.GOLDEN_SECTION, function, a, b, 0.00000001));

        result.add(getMethod(MethodEnum.FIBONACCI, function, a, b, 0.01));
        result.add(getMethod(MethodEnum.FIBONACCI, function, a, b, 0.0001));
        result.add(getMethod(MethodEnum.FIBONACCI, function, a, b, 0.00000001));

        result.add(getMethod(MethodEnum.PARABOLA, function, a, b, 0.01));
        result.add(getMethod(MethodEnum.PARABOLA, function, a, b, 0.0001));
        result.add(getMethod(MethodEnum.PARABOLA, function, a, b, 0.00000001));
        return result;
    }
}
