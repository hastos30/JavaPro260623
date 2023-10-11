package main.java.lesson18;

import main.java.lesson18.handlers.FileHandler;
import main.java.lesson18.handlers.MostFrequentWordsCounter;
import main.java.lesson18.handlers.SentenceCounter;
import main.java.lesson18.handlers.WordCounter;
import main.java.lesson18.threads.TextProcessingThread;

public class Main {
    public static void main(String[] args) {
        try {
            String inputText =
                    FileHandler.readInputFile("JavaPro260623/src/main/java/lesson18/inputFile/input.txt");

            TextProcessingThread wordCounterThread = new TextProcessingThread(
                    new WordCounter(), inputText,
                    "JavaPro260623/src/main/java/lesson18/outputFile/word_count.txt");
            TextProcessingThread sentenceCounterThread = new TextProcessingThread(
                    new SentenceCounter(), inputText,
                    "JavaPro260623/src/main/java/lesson18/outputFile/sentence_count.txt");
            TextProcessingThread frequentWordsCounterThread = new TextProcessingThread(
                    new MostFrequentWordsCounter(), inputText,
                    "JavaPro260623/src/main/java/lesson18/outputFile/frequent_words.txt");

            wordCounterThread.start();
            sentenceCounterThread.start();
            frequentWordsCounterThread.start();

            wordCounterThread.join();
            sentenceCounterThread.join();
            frequentWordsCounterThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





