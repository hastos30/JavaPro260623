package main.java.lesson18.handlers;

public class SentenceCounter implements TextProcessor {
    @Override
    public String processText(String text) {
        String[] sentences = text.split("(?<=[.!?])\\s+");
        int sentenceCount = sentences.length;
        return "Количество предложений в тексте: " + sentenceCount;
    }
}