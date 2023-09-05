package main.java.lesson12;

import java.util.*;

public class AnimalTasksSolver {

    public static void main(String[] args) {
        List<String> wildAnimals = Arrays.asList("Lion", "Tiger", "Elephant", "Giraffe");

        List<String> pets = Arrays.asList("Dog", "Cat", "Fish", "Parrot");

        Map<String, Integer> animalLegs = new HashMap<>();
        animalLegs.put("Lion", 4);
        animalLegs.put("Tiger", 4);
        animalLegs.put("Elephant", 4);
        animalLegs.put("Giraffe", 4);
        animalLegs.put("Dog", 4);
        animalLegs.put("Cat", 4);
        animalLegs.put("Fish", 0);
        animalLegs.put("Parrot", 2);

        String animalWithMostLegs = findAnimalWithMostLegs(animalLegs);
        System.out.println("Animal with the most legs: " + animalWithMostLegs);

        List<String> randomAnimals = generateRandomAnimals(100);

        int totalLegs = calculateTotalLegs(randomAnimals, animalLegs);
        System.out.println("Total number of legs: " + totalLegs);

        Map<Integer, List<String>> groupedAnimals = groupAnimalsByLegs(randomAnimals, animalLegs);
        System.out.println("Animals grouped by number of legs: " + groupedAnimals);

        Map<String, Integer> speciesCount = countAnimalsBySpecies(randomAnimals);
        System.out.println("Species count: " + speciesCount);

        int speciesCountTotal = speciesCount.size();
        System.out.println("Total number of species: " + speciesCountTotal);
    }

    private static String findAnimalWithMostLegs(Map<String, Integer> animalLegs) {
        return Collections.max(animalLegs.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static List<String> generateRandomAnimals(int count) {
        List<String> animals = new ArrayList<>();
        Random random = new Random();
        List<String> availableSpecies = Arrays.asList("Lion", "Tiger", "Elephant", "Giraffe", "Dog", "Cat", "Fish", "Parrot");

        for (int i = 0; i < count; i++) {
            String randomSpecies = availableSpecies.get(random.nextInt(availableSpecies.size()));
            animals.add(randomSpecies);
        }

        return animals;
    }

    private static int calculateTotalLegs(List<String> animals, Map<String, Integer> animalLegs) {
        int totalLegs = 0;
        for (String animal : animals) {
            totalLegs += animalLegs.getOrDefault(animal, 0);
        }
        return totalLegs;
    }

    private static Map<Integer, List<String>> groupAnimalsByLegs(List<String> animals, Map<String, Integer> animalLegs) {
        Map<Integer, List<String>> groupedAnimals = new HashMap<>();
        for (String animal : animals) {
            int legs = animalLegs.getOrDefault(animal, 0);
            groupedAnimals.computeIfAbsent(legs, k -> new ArrayList<>()).add(animal);
        }
        return groupedAnimals;
    }

    private static Map<String, Integer> countAnimalsBySpecies(List<String> animals) {
        Map<String, Integer> speciesCount = new HashMap<>();
        for (String animal : animals) {
            speciesCount.put(animal, speciesCount.getOrDefault(animal, 0) + 1);
        }
        return speciesCount;
    }}

