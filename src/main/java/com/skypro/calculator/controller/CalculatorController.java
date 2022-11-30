package com.skypro.calculator.controller;

import com.skypro.calculator.exception.IllegalNumberException;
import com.skypro.calculator.service.CalculatorService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberException(IllegalNumberException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @RequestMapping("/")
    public String greeting() {
        return "Добро пожаловать калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1,
                        @RequestParam("num2") int num2) {
        int result = calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d",num1,num2,result);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1,
                        @RequestParam("num2") int num2) {
        int result = calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d",num1,num2,result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1,
                        @RequestParam("num2") int num2) {
        int result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d",num1,num2,result);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1,
                        @RequestParam("num2") int num2) {
        int result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d",num1,num2,result);
    }


}
