package main.java.lesson18.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentWordsCounter implements TextProcessor {
    @Override
    public String processText(String text) {
        String[] words = text.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            String cleanedWord = word.toLowerCase();

            cleanedWord = cleanedWord.replaceAll("[.,!?\"';:]", "");

            if (cleanedWord.length() >= 3) {
                wordCountMap.put(cleanedWord, wordCountMap.getOrDefault(cleanedWord, 0) + 1);
            }
        }

        String result = "Самые часто-повторяющиеся слова и количество их повторений:\n";
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (int i = 0; i < Math.min(10, sortedEntries.size()); i++) {
            Map.Entry<String, Integer> entry = sortedEntries.get(i);
            result += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        return result;
    }
}
