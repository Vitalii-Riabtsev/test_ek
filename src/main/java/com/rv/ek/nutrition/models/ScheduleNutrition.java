package com.rv.ek.nutrition.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Min;
import java.util.Date;

@Table("schedule_nutrition")
public class ScheduleNutrition {
    @Id
    @Column("id")
    private long id;

    @Column("customer_id")
    private long customerID;

    @Min(1)
    @Column("meal_plan_id")
    private long mealPlanID;

    @Min(1)
    @Column("day_id")
    private int dayID;

    @Column("functional_flag_mask")
    private int functionalFlagMask;

    @Column("start_date")
    private Date startDate;

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

    public long getMealPlanID() {
        return mealPlanID;
    }

    public void setMealPlanID(long mealPlanID) {
        this.mealPlanID = mealPlanID;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public int getFunctionalFlagMask() {
        return functionalFlagMask;
    }

    public void setFunctionalFlagMask(int functionalFlagMask) {
        this.functionalFlagMask = functionalFlagMask;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
