package com.company;

import com.company.methods.LocalizationMethod;
import com.company.methods.ResultEntry;

import java.util.List;


public class ConsoleRunner {

    public static void run() {
        try {
            Function function = x -> Math.pow(x, 6) - 3 * Math.pow(x, 2) + 5 * x + 1;

            List<Solvable> methods = MethodFactory.getAllMethods(function, -2, 0);

            for (Solvable solvable : methods) {

                System.out.println(solvable.getClass().getSimpleName() + "\twith epsilon:" + solvable.getEpsilon());
                ResultEntry solution = solvable.solve();
                System.out.println("x* = " + solution.getSolutionValue());
                System.out.println("f* = " + solution.getSolutionFunctionValue());
                System.out.println("Number of iterations = " + solution.getIterationCount());
                System.out.println("Number of function calls = " + solution.getFunctionCalculationCount());
                System.out.println("");
            }
        } catch (PreciseSolutionFailedException ex) {
            System.out.println("a = " + ex.getA());
            System.out.println("b = " + ex.getB());
        }
    }
}
