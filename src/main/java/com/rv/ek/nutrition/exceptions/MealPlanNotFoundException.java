package com.rv.ek.nutrition.exceptions;

public class MealPlanNotFoundException extends RuntimeException {
    public MealPlanNotFoundException(Long id) {
        super(String.format("Could not find meal plan ID: %d", id));
    }
}
