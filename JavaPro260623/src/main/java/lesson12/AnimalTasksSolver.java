package main.java.lesson12;

import java.util.*;
import java.util.stream.Collectors;

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

        Map<String, Long> speciesCount = countAnimalsBySpecies(randomAnimals);
        System.out.println("Species count: " + speciesCount.size());
    }

    private static String findAnimalWithMostLegs(Map<String, Integer> animalLegs) {
        return animalLegs.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No animals found");
    }

    private static List<String> generateRandomAnimals(int count) {
        Random random = new Random();
        List<String> availableSpecies = Arrays.asList("Lion", "Tiger", "Elephant", "Giraffe", "Dog", "Cat", "Fish", "Parrot");

        return random.ints(count, 0, availableSpecies.size())
                .mapToObj(availableSpecies::get)
                .collect(Collectors.toList());
    }

    private static int calculateTotalLegs(List<String> animals, Map<String, Integer> animalLegs) {
        return animals.stream()
                .map(animalLegs::get)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static Map<Integer, List<String>> groupAnimalsByLegs(List<String> animals, Map<String, Integer> animalLegs) {
        return animals.stream()
                .collect(Collectors.groupingBy(animalLegs::get));
    }

    private static Map<String, Long> countAnimalsBySpecies(List<String> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(
                        animal -> animal,
                        Collectors.counting()
                ));
    }
}
