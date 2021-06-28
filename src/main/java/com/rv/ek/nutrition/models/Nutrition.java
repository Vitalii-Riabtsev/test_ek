package com.rv.ek.nutrition.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Nutrition {
    @Id
    @Column("nutrition_id")
    private long id;

    @Column("nutrition_type")
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
