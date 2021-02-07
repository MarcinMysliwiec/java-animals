package com.university.Models;

import com.university.Interfaces.FeedableAnimal;
import com.university.Enums.Gender;

import java.time.LocalDate;

public class Mammal extends Animal implements FeedableAnimal {
    private final static Integer DEFAULT_MAX_FOOD = 50;
    private Integer legs;
    
    public Mammal(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Integer legsParam, Boolean isDomesticParam) {
        this(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, legsParam, isDomesticParam, DEFAULT_MAX_FOOD);
    }

    public Mammal(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Integer legsParam, Boolean isDomesticParam, Integer maxFoodParam) {
        super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, isDomesticParam, maxFoodParam);
        legs = legsParam;
    }
    
    public Integer getLegs() {
        return legs;
    }

    @Override
    public String toString()
    {
        return printAnimal() +
                "\n\tIlość nóg: " + getLegs();
    }
    
    @Override
    public void feedAnimal() {
        increaseFoodParam();
    }
}
