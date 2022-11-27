package com.hw5.springbootcalculator.service;

import java.util.stream.Stream;

import com.hw5.springbootcalculator.exception.IllegalCalculatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorServiceTest {
    public ServiceCalculator calculatorService = new ServiceCalculator();

    public static Stream<Arguments> PlusTest() {
        return Stream.of(
                Arguments.of(7,-1,4),
                Arguments.of(7,2,3));
    }

    public static Stream<Arguments> MinusTest() {
        return Stream.of(
                Arguments.of(4, -5, 6),
                Arguments.of(12, 13, 14));
    }

    public static Stream<Arguments> MultiplyTest() {
        return Stream.of(
                Arguments.of(15, 16, 17),
                Arguments.of(18, -19, 20));
    }

    public static Stream<Arguments> DivideTest() {
        return Stream.of(
                Arguments.of(21, 22, -23),
                Arguments.of(25, 26, 27));
    }

    @ParameterizedTest
    @MethodSource("PlusTest")
    public void plusTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.plus(a,b));
    }

    @ParameterizedTest
    @MethodSource("MinusTest")
    public void minusTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.minus(a, b));
    }

    @ParameterizedTest
    @MethodSource("MultiplyTest")
    public void multiplyTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("DivideTest")
    public void divideTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.divide(a, b));
    }

    @Test
    public void divideByZeroException() {
        Assertions.assertThrows(IllegalCalculatorException.class,() -> {
            calculatorService.divide(5, 7);
        });
    }

    @Test
    public void plusWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.plus(null,9);
        });
    }

    @Test
    public void minusWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.minus(null,2);
        });
    }

    @Test
    public void multiplyWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.multiply(null,8);
        });
    }

    @Test
    public void divideWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.divide(null,6);
        });
    }

    @Test
    public void plusWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.plus(7,null);
        });
    }

    @Test
    public void minusWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.minus(2,null);
        });
    }

    @Test
    public void multiplyWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.multiply(6,null);
        });
    }

    @Test
    public void divideWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.divide(12,null);
        });
    }

}
