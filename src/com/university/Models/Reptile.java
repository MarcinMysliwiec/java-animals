package com.university.Models;

import com.university.Interfaces.FeedableAnimal;
import com.university.Enums.Gender;

import java.time.LocalDate;

public class Reptile extends Animal implements FeedableAnimal {
    private final static Integer DEFAULT_MAX_FOOD = 40;
    private Boolean hasLegs;

    public Reptile(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Boolean hasLegsParam, Boolean isDomesticParam) {
        this(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, hasLegsParam, isDomesticParam, DEFAULT_MAX_FOOD);
    }

    public Reptile(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Boolean hasLegsParam, Boolean isDomesticParam, Integer maxFoodParam) {
        super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, isDomesticParam, maxFoodParam);
        hasLegs = hasLegsParam;
    }

    public String getHasLegsString() {
        if (hasLegs) {
            return "Posiada";
        }
        return "Brak";
    }

    @Override
    public String toString() {
        return printAnimal() +
                "\n\tOdnóża: " + getHasLegsString();
    }

    @Override
    public void feedAnimal() {
        increaseFoodParam();
    }
}
