package com.rv.ek.nutrition.exceptions;

public class ScheduleNotDefinedException extends RuntimeException {
    public ScheduleNotDefinedException(int id) {
        super(String.format("Could not find schedule for day ID: %d", id));
    }
}
