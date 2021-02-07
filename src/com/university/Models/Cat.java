package com.university.Models;

import com.university.Interfaces.FeedableAnimal;
import com.university.Interfaces.PetableAnimal;
import com.university.Enums.CatBreed;
import com.university.Enums.Gender;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cat extends DomesticAnimal implements FeedableAnimal, PetableAnimal {
	private final static Integer DEFAULT_LEGS = 4;
	private final static Integer DEFAULT_MAX_FOOD = 35;
	private CatBreed breed;

	public Cat(String idParam, String nameParam, Double weightParam, LocalDate dateOfBirthParam, Gender genderParam, CatBreed breedParam) {
		super(idParam, nameParam, weightParam, dateOfBirthParam, genderParam, DEFAULT_LEGS, DEFAULT_MAX_FOOD);
		breed = breedParam;
	}

	public CatBreed getBreed() {
		return breed;
	}

	@Override
	public String toString() {
		return super.toString() +
				"\n\tRasa: " + getBreed();
	}

	@Override
	public String speak() {
		return "Miau";
	}

	@Override
	public void feedAnimal() {
		increaseFoodParam();
	}

	@Override
	public void petAnimal() {
		increaseHappiness(10);
	}
}
