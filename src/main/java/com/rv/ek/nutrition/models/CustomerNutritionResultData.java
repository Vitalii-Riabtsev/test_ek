package com.rv.ek.nutrition.models;

import java.util.List;

public class CustomerNutritionResultData {
    private Meal meal;
    private List<MealPlanNutrition> targetNutrition;
    private List<TrackNutrition> consumedNutrition;
    private long score;

    public CustomerNutritionResultData(Meal meal, List<MealPlanNutrition> targetNutrition, List<TrackNutrition> consumedNutrition, Long score) {
        this.consumedNutrition = consumedNutrition;
        this.targetNutrition = targetNutrition;
        this.score = score;
        this.meal = meal;
    }

    public List<TrackNutrition> getConsumedNutrition() {
        return consumedNutrition;
    }

    public void setConsumedNutrition(List<TrackNutrition> consumedNutrition) {
        this.consumedNutrition = consumedNutrition;
    }

    public List<MealPlanNutrition> getTargetNutrition() {
        return targetNutrition;
    }

    public void setTargetNutrition(List<MealPlanNutrition> targetNutrition) {
        this.targetNutrition = targetNutrition;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}