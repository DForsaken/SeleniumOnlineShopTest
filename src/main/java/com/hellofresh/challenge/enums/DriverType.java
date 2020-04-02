package com.hellofresh.challenge.enums;

import java.util.HashMap;
import java.util.Map;

public enum DriverType {
    CHROME("chrome"),
    FIREFOX("firefox");

    private String type;

    DriverType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    private static final Map<String, DriverType> lookup = new HashMap<>();

    static
    {
        for(DriverType env : DriverType.values())
        {
            lookup.put(env.getType(), env);
        }
    }

    //This method can be used for reverse lookup purpose
    public static DriverType get(String type)
    {
        return lookup.get(type);
    }
}
