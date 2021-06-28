package com.rv.ek.nutrition.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NutritionControllerAdvice {
    @ResponseBody
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String customerNotFoundHandler(CustomerNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String notValidArgumentHandler(MethodArgumentNotValidException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ScheduleNotDefinedException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String scheduleNotDefinedHandler(ScheduleNotDefinedException ex) {
        return ex.getMessage();
    }
}
