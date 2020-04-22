package com.company;

import java.util.List;


public class ConsoleRunner {

    public static void run() {

        Function function = x -> Math.pow(x, 6) - 3 * x * x + 5 * x + 1;

        List<Solvable> methods = MethodFactory.getAllMethods(function, -2, 0);

        for (Solvable solvable : methods) {

            System.out.println(solvable.getClass().getSimpleName());
            double solution = solvable.solve();
            System.out.println("x* = " + solution);
            System.out.println("f* = " + function.calculate(solution));
            System.out.println("Number of iterations = " + solvable.getIterationCount());
            System.out.println("Number of function calls = " + solvable.getFunctionCalculationCount());
            System.out.println("");
        }
    }
}
