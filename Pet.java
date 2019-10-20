package com.collabera.streams;

public class Pet {
	
	//Fields
	private final String name;
	//Enum for Gender - male or female
	private final Gender gender;
	//Enum for Specie - cat or dog
	private final Specie specie;
	private final String breed;
	private final int generation;
	
	//Getters for the Fields
	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Specie getSpecie() {
		return specie;
	}

	public String getBreed() {
		return breed;
	}

	public int getGeneration() {
		return generation;
	}

	//Constructor
	public Pet(String name, Gender gender, Specie specie, String breed, int generation) {
		this.name = name;
		this.gender = gender;
		this.specie = specie;
		this.breed = breed;
		this.generation = generation;
	}

	//ToString from our Fields
	@Override
	public String toString() {
		return "Pet [name=" + name + ", gender=" + gender + ", specie=" + specie + ", breed=" + breed + ", generation="
				+ generation + "]";
	}

}
