package com.university.Enums;

import java.util.ArrayList;
import java.util.List;

public enum Gender {
    MALE("SAMIEC"),
    FEMALE("SAMICA");

    private String polishName;

    Gender(String polishNameParam) {
        polishName = polishNameParam;
    }

    @Override
    public String toString() {
        return polishName;
    }

    public static String printAll() {
        List<String> valueList = new ArrayList<String>();
        for (Gender gender : Gender.values()) {
            valueList.add(gender.polishName);
        }
        return String.join(", ", valueList);
    }
}