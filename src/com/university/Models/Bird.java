package com.university.Models;

import com.university.Interfaces.FeedableAnimal;
import com.university.Enums.BillType;
import com.university.Enums.Gender;

import java.time.LocalDate;

public class Bird extends Animal implements FeedableAnimal {
    private final static Integer DEFAULT_MAX_FOOD = 15;
    private BillType billType;

    public Bird(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, BillType billTypeParam, Boolean isDomesticParam) {
        this(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, billTypeParam, isDomesticParam, DEFAULT_MAX_FOOD);
    }

    public Bird(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, BillType billTypeParam, Boolean isDomesticParam, Integer maxFoodParam) {
        super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, isDomesticParam, maxFoodParam);
        billType = billTypeParam;
    }

    public String getBillType() {
        return billType.toString();
    }

    @Override
    public String toString() {
        return printAnimal() +
                "\n\tDziób: " + getBillType();
    }

    @Override
    public void feedAnimal() {
        increaseFoodParam();
    }
}
