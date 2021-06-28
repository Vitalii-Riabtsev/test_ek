package com.rv.ek.nutrition.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table("meal_plan_nutrition")
public class MealPlanNutrition {
    @Id
    @Column("id")
    private long id;

    @Column("meal_plan_id")
    private long mealPlanID;

    @Min(1)
    @Column("meal_id")
    private int mealID;

    @Min(1)
    @Column("nutrition_id")
    private int nutritionID;

    @NotNull
    @Min(0)
    @Max(10000)
    @Column("value")
    private int value;

    @Column("start_date")
    private Date startDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMealPlanID() {
        return mealPlanID;
    }

    public void setMealPlanID(long mealPlanID) {
        this.mealPlanID = mealPlanID;
    }

    public int getMealID() {
        return mealID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public int getNutritionID() {
        return nutritionID;
    }

    public void setNutritionID(int nutritionID) {
        this.nutritionID = nutritionID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
