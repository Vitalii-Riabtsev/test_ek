package com.rv.ek.nutrition.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("meals")
public class Meal {
    @Id
    @Column("meal_id")
    private int id;

    @Column("meal_type")
    private String type;

    @Column("functional_flag_mask")
    private int functionalFlagMask;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFunctionalFlagMask() {
        return functionalFlagMask;
    }

    public void setFunctionalFlagMask(int functionalFlagMask) {
        this.functionalFlagMask = functionalFlagMask;
    }
}
