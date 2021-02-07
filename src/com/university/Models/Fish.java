package com.university.Models;

import com.university.Interfaces.FeedableAnimal;
import com.university.Enums.Gender;

import java.time.LocalDate;

public class Fish extends Animal implements FeedableAnimal {
	private final static Integer DEFAULT_MAX_FOOD = 15;
	private Double maxSwimDepth;

	public Fish(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Double maxSwimDepthParam, Boolean isDomesticParam) {
		this(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, maxSwimDepthParam, isDomesticParam, DEFAULT_MAX_FOOD);
	}

	public Fish(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Double maxSwimDepthParam, Boolean isDomesticParam, Integer maxFoodParam) {
		super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, isDomesticParam, maxFoodParam);
		maxSwimDepth = maxSwimDepthParam;
	}

	public Double getMaxSwimDepth() {
		return maxSwimDepth;
	}

	@Override
	public String toString() {
		return printAnimal() +
				"\n\tMaksymalne zanurzenie: " + getMaxSwimDepth();
	}

	@Override
	public void feedAnimal() {
		increaseFoodParam();
	}
}
