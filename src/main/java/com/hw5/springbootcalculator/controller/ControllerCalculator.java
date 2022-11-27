package com.hw5.springbootcalculator.controller;

import com.hw5.springbootcalculator.exception.IllegalCalculatorException;
import com.hw5.springbootcalculator.service.ServiceCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*### **@RestController**

Данной аннотацией помечаются классы-контроллеры, которые возвращают пользователю (или приложению) некий объект
(или коллекцию объектов) в формате JSON/XML.

С технической точки зрения является «сборной» аннотацией, состоящей из @Controller и @ResponseBody, вторая
из которых позволяет Spring трактовать возвращенный из метода объект в качестве ответа на запрос к контроллеру,
переводя его в JSON или XML.*/

/*Написать 5 методов, которые при вызове из браузера делают следующее:

1. Метод по адресу /calculator должен вернуть приветствие “Добро пожаловать в калькулятор”.

2. Метод по адресу /calculator/plus?num1=5&num2=5 должен сложить num1 и num2 и вернуть результат в формате “5 + 5 = 10”.

3. Метод по адресу /calculator/minus?num1=5&num2=5 должен вычесть из num1 num2 и вернуть результат в формате “5 − 5 = 0”.

4. Метод по адресу /calculator/multiply?num1=5&num2=5 должен умножить num1 на num2 и вернуть результат в формате “5 * 5 = 25”.

5. Метод по адресу /calculator/divide?num1=5&num2=5 должен разделить num1 на num2 и вернуть результат в формате “5 / 5 = 1”.*/

@RestController
@RequestMapping("/calculator")
public class ControllerCalculator {
    private final ServiceCalculator serviceCalculator;

    public ControllerCalculator(ServiceCalculator serviceCalculator) {
        this.serviceCalculator = serviceCalculator;
    }
    @GetMapping
    public String getWelcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public int plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return this.serviceCalculator.plus(a, b);
    }

    @GetMapping("/minus")
    public int minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return this.serviceCalculator.minus(a, b);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        return this.serviceCalculator.multiply(a, b);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam("num1") int a, @RequestParam("num2") int b) throws IllegalCalculatorException {
        return this.serviceCalculator.divide(a, b);
    }
}
