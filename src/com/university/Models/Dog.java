package com.university.Models;

import com.university.Interfaces.FeedableAnimal;
import com.university.Interfaces.PetableAnimal;
import com.university.Enums.DogBreed;
import com.university.Enums.Gender;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dog extends DomesticAnimal implements FeedableAnimal, PetableAnimal {
	private final static Integer DEFAULT_LEGS = 4;
	private final static Integer DEFAULT_MAX_FOOD = 50;
	private DogBreed breed;

	public Dog(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, DogBreed breedParam) {
		super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, DEFAULT_LEGS, DEFAULT_MAX_FOOD);
		breed = breedParam;
	}

	public DogBreed getBreed() {
		return breed;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\n\tRasa: " + getBreed();
	}

	@Override
	public String speak() {
		return "Hał Hał Hał";
	}

	@Override
	public void feedAnimal() {
		increaseFoodParam();
	}

	@Override
	public void petAnimal() {
		increaseHappiness(20);
	}
}
