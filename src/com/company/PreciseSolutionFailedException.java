package com.company;

public class PreciseSolutionFailedException extends RuntimeException {

    private final double a;
    private final double b;

    public PreciseSolutionFailedException(String message, double a, double b) {
        super(message);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
