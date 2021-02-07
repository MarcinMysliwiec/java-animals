package com.university.Models;

import com.university.Enums.Gender;

import java.time.LocalDate;

public abstract class DomesticAnimal extends Mammal {
	private final static Boolean DEFAULT_IS_DOMESTIC = true;
	private final static Integer DEFAULT_MAX_HAPPINESS = 100;
	private Integer happiness;

	public DomesticAnimal(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Integer legsParam, Integer maxFoodParam) {
		super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, legsParam, DEFAULT_IS_DOMESTIC, maxFoodParam);
		happiness = DEFAULT_MAX_HAPPINESS / 2;
	}

	public void decreaseHappiness() {
		happiness -= DEFAULT_MAX_HAPPINESS / 10;
		if (happiness < 0) {
			happiness = 0;
		}
	}

	protected void increaseHappiness(Integer happinessParam) {
		happiness += happinessParam;
		if (happiness > DEFAULT_MAX_HAPPINESS) {
			happiness = DEFAULT_MAX_HAPPINESS;
		}
	}

	public abstract String speak();

	private Integer happinessPercentage() {
		return happiness * 100 / DEFAULT_MAX_HAPPINESS;
	}

	@Override
	public String toString() {
		return printAnimal() +
				"\n\tZadowolenie: " + happiness + "/" + DEFAULT_MAX_HAPPINESS + " (" + happinessPercentage() + "%)" +
				"\n\tDaj głos: " + speak();
	}
}
