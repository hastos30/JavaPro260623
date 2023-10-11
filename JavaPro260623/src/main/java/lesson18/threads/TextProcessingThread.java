package main.java.lesson18.threads;

import main.java.lesson18.handlers.FileHandler;
import main.java.lesson18.handlers.TextProcessor;

public class TextProcessingThread extends Thread {
    private TextProcessor processor;
    private String inputText;
    private String outputPath;

    public TextProcessingThread(TextProcessor processor, String inputText, String outputPath) {
        this.processor = processor;
        this.inputText = inputText;
        this.outputPath = outputPath;
    }

    @Override
    public void run() {
        String result = processor.processText(inputText);
        try {
            FileHandler.writeOutputFile(outputPath, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
