package com.hw5.springbootcalculator.service;


import com.hw5.springbootcalculator.exception.IllegalCalculatorException;
import org.springframework.stereotype.Service;

@Service
public class ServiceCalculator {

    public int plus(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Нужно ввести два числа!");
        }
        return a + b;
    }

    public int minus(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Нужно ввести два числа!");
        }
        return a - b;
    }

    public int multiply(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Нужно ввести два числа!");
        }
        if (a == 0 || b == 0) {
            throw new IllegalCalculatorException("На 0 умножать нельзя");
        }
            return a * b;
    }

    public int divide(Integer a, Integer b) throws IllegalCalculatorException {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Нужно ввести два числа!");
        }
        if (a == 0 || b == 0) {
            throw new IllegalCalculatorException("На 0 делить нельзя");
        }
            return a / b;
    }
}
