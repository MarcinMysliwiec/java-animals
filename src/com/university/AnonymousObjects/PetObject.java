package com.university.AnonymousObjects;

public class PetObject {
    private String description;
    private Integer score;

    public PetObject(String descriptionParam, Integer scoreParam) {
        description = descriptionParam;
        score = scoreParam;
    }

    public String getDescription() {
        return description;
    }

    public Integer getScore() {
        return score;
    }
}
