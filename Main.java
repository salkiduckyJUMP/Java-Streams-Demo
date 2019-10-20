package com.collabera.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Pet> pets = getPet();

		// Imperative Approach

		/*
		 * List<Pet> females = new ArrayList<>();
		 * 
		 * for (Pet pet : pets) {
		 * 
		 * if (pet.getGender().equals(Gender.FEMALE)) { females.add(pet); } }
		 * 
		 * //Should print out only the female pets females.forEach(System.out::println);
		 */

		// Streams are made for dealing with collections
		// Can tell it directly what we want it to do instead of defining each step
		// ourselves

		// Declarative Approach

		////////// Filter
		List<Pet> females = pets.stream().filter(pet -> pet.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());

		// Prints out all females from the Set
		// females.forEach(System.out::println);

		////////// Sort
		// Sort by generation in ascending order
		List<Pet> sorted = pets.stream().sorted(Comparator.comparing(Pet::getGeneration)).collect(Collectors.toList());
		// sorted.forEach(System.out::println);

		// Chaining comparators
		// Sort by generation then sort by species in descending order
		List<Pet> sorted2 = pets.stream()
				.sorted(Comparator.comparing(Pet::getGeneration).thenComparing(Pet::getSpecie).reversed())
				.collect(Collectors.toList());
		// sorted2.forEach(System.out::println);

		////////// All Match
		// Checks if all pets have a generation higher than 10
		boolean allMatch = pets.stream().allMatch(pet -> pet.getGeneration() > 10);

		// Returns as false as we have 5 pets that don't match that criteria
		// System.out.println(allMatch);

		////////// Any Match
		// Checks if any element in the set has a generation of 272
		boolean anyMatch = pets.stream().anyMatch(pet -> pet.getGeneration() == 272);

		// Returns true because of Avril
		// System.out.println(anyMatch);

		////////// None Match
		// Checks if no pets in the set are the breed of Chihuahua
		boolean noneMatch = pets.stream().noneMatch(pet -> pet.getBreed().equals("Chihuahua"));

		// Returns false because of Pepper
		// System.out.println(noneMatch);

		////////// Max
		pets.stream().max(Comparator.comparing(Pet::getGeneration))
				// Returns the pet with the highest generation, Pepper
				.ifPresent(System.out::println);

		////////// Min
		pets.stream().min(Comparator.comparing(Pet::getGeneration))
				// Returns the pet with the lowest generation, it returns Erin as she is the
				// first gen 1
				.ifPresent(System.out::println);
	}

	// List of Pets
	private static List<Pet> getPet() {
		return List.of(new Pet("Erin", Gender.FEMALE, Specie.DOG, "Dalmatian", 1),
				new Pet("Sol", Gender.MALE, Specie.CAT, "Maine Coon", 1),
				new Pet("Kronos", Gender.MALE, Specie.DOG, "Scottie", 2),
				new Pet("Dandelion", Gender.FEMALE, Specie.CAT, "Russian Blue", 371),
				new Pet("Caesar", Gender.MALE, Specie.DOG, "Dalmatian", 238),
				new Pet("Avril", Gender.FEMALE, Specie.CAT, "B+W Shorthair", 272),
				new Pet("Aesop", Gender.MALE, Specie.CAT, "Persian", 256),
				new Pet("Coco", Gender.FEMALE, Specie.DOG, "Great Dane", 1),
				new Pet("Kenna", Gender.FEMALE, Specie.DOG, "Labrador", 2),
				new Pet("Pepper", Gender.FEMALE, Specie.DOG, "Chihuahua", 559)

		);
	}

}
