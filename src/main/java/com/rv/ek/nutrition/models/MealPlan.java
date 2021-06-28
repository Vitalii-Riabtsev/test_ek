package com.rv.ek.nutrition.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table("meal_plans")
public class MealPlan {
    @Id
    @Column("meal_plan_id")
    private long id;

    @Column("customer_id")
    private long customerID;

    @NotNull
    @Size(min=2, max=100)
    @Column("meal_plan_name")
    private String name;

//    @MappedCollection(idColumn = "meal_plan_id", keyColumn = "meal_plan_id")
//    private List<@Valid MealPlanNutrition> mealPlanNutritionList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<MealPlanNutrition> getMealPlanNutritionList() {
//        return mealPlanNutritionList;
//    }
//
//    public void setMealPlanNutritionList(List<MealPlanNutrition> mealPlanNutritionList) {
//        this.mealPlanNutritionList = mealPlanNutritionList;
//    }
}
