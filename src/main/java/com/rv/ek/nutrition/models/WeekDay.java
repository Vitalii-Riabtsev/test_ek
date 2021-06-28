package com.rv.ek.nutrition.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.*;

public enum WeekDay {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    ;
    public final int id;

    WeekDay(int id) {
        this.id = id;
    }

    private static final Map<WeekDay, Map<String, Object>> listOfValues = new HashMap<WeekDay, Map<String, Object>>() {{
        for (WeekDay weekDay : WeekDay.values()) {
            put(weekDay, new HashMap<String, Object>() {{
                put("name", weekDay.name());
                put("id", weekDay.id);
            }});
        }
    }};

    @JsonValue
    public Map<String, Object> toValue() {
        return listOfValues.get(this);
    }

    public static int isoDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayNumber = c.get(Calendar.DAY_OF_WEEK);
        return dayNumber > 1 ? dayNumber - 1 : SUNDAY.id;
    }
}
