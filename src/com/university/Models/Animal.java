package com.university.Models;

import com.university.Enums.Gender;

import java.time.LocalDate;

public abstract class Animal {
	private String id;
	private String name;
	private Double weight;
	private LocalDate dateOfBirth;
	private Gender gender;
	private Boolean isDomestic;

	private Integer food;
	private Integer maxFood;

	public Animal(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, Boolean isDomesticParam, Integer maxFoodParam) {
		id = idParam;
		name = nameParam;
		weight = weightParam;
		dateOfBirth = dateOfBirthParam;
		gender = genderParam;
		isDomestic = isDomesticParam;
		maxFood = maxFoodParam;
		food = maxFoodParam / 2;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getWeight() {
		return weight;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public String getDomesticString() {
		if (isDomestic) {
			return "tak";
		}
		return "nie";
	}

	public void decreaseFoodParam() {
		food -= maxFood / 5;
		if (food < 0) {
			food = 0;
		}
	}

	protected void increaseFoodParam() {
		food += maxFood / 3;
		if (food > maxFood) {
			food = maxFood;
		}
	}

	private Integer foodPercentage() {
		return food * 100 / maxFood;
	}

	protected String printAnimal() {
		return ">>> Id: " + id +
				"\n\tImie: " + getName() +
				"\n\tWaga: " + getWeight() + " kg" +
				"\n\tPłeć: " + getGender() +
				"\n\tData Urodzenia: " + getDateOfBirth().toString() +
				"\n\tUdomowiony: " + getDomesticString().toUpperCase() +
				"\n\tPoziom jedzenia : " + food + "/" + maxFood + " (" + foodPercentage() + "%)";
	}
}
