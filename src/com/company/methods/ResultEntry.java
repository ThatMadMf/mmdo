package com.company.methods;

public class ResultEntry {

    private double solutionValue;
    private double solutionFunctionValue;
    private int iterationCount;
    private int functionCalculationCount;

    public ResultEntry(double solutionValue, double solutionFunctionValue,
                       int iterationCount, int functionCalculationCount) {
        this.solutionValue = solutionValue;
        this.solutionFunctionValue = solutionFunctionValue;
        this.iterationCount = iterationCount;
        this.functionCalculationCount = functionCalculationCount;
    }

    public double getSolutionValue() {
        return solutionValue;
    }

    public double getSolutionFunctionValue() {
        return solutionFunctionValue;
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public int getFunctionCalculationCount() {
        return functionCalculationCount;
    }
}
