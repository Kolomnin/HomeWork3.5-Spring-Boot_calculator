package com.hw5.springbootcalculator.exception;

public class IllegalCalculatorException extends IllegalArgumentException {
    public IllegalCalculatorException(String exp) {
        super(exp);
    }
}

