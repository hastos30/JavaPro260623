package main.java.lesson9.task1;

import java.util.*;

public class CollectionUtil {
    public static <T> int countOccurrence(List<T> list, T target) {
        int count = 0;
        for (T item : list) {
            if (Objects.equals(item, target)) {
                count++;
            }
        }
        return count;
    }

    public static <E> List<E> toList(E[] array) {
        List<E> list = new MyLinkedList<>();
        Collections.addAll(list, array);
        return list;
    }

    public static List<Integer> findUnique(List<Integer> numberList) {
        Set<Integer> uniqueSet = new HashSet<>();
        List<Integer> uniqueList = new MyLinkedList<>();
        for (Integer number : numberList) {
            if (!uniqueSet.contains(number)) {
                uniqueSet.add(number);
                uniqueList.add(number);
            }
        }
        return uniqueList;
    }

    public static void calcOccurrence(List<String> wordList) {

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordList) {
            Integer count = wordCountMap.getOrDefault(word, 0);

            wordCountMap.put(word, count + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static List<WordOccurrence> findOccurrence(List<String> wordList) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordList) {
            Integer count = wordCountMap.getOrDefault(word, 0);

            wordCountMap.put(word, count + 1);
        }

        List<WordOccurrence> occurrences = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            occurrences.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        return occurrences;
    }

    private static class WordOccurrence {
        private final String name;
        private final int occurrence;

        public WordOccurrence(String name, int occurrence) {
            this.name = name;
            this.occurrence = occurrence;
        }

        public String getName() {
            return name;
        }

        public int getOccurrence() {
            return occurrence;
        }
    }
}
