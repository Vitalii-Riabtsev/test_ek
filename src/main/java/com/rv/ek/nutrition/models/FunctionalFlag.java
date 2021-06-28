package com.rv.ek.nutrition.models;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum FunctionalFlag {
    WORKOUT(1<<0),
    ;

    public final int id;

    FunctionalFlag(int id) {
        this.id = id;
    }

    private static final Map<FunctionalFlag, Map<String, Object>> listOfValues = new HashMap<FunctionalFlag, Map<String, Object>>() {{
        for (FunctionalFlag flag : FunctionalFlag.values()) {
            put(flag, new HashMap<String, Object>() {{
                put("name", flag.name());
                put("id", flag.id);
            }});
        }
    }};

    @JsonValue
    public Map<String, Object> toValue() {
        return listOfValues.get(this);
    }
}
