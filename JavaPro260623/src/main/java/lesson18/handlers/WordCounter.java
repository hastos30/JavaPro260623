package main.java.lesson18.handlers;

public class WordCounter implements TextProcessor {
    @Override
    public String processText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        return "Количество слов в тексте: " + wordCount;
    }
}