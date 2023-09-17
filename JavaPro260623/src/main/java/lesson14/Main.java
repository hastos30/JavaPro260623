package main.java.lesson14;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileLoggerConfiguration configuration = new FileLoggerConfiguration(
                    "Log", LoggingLevel.DEBUG, 1024, "yyyy-MM-dd HH:mm:ss"
            );

            FileLogger logger = new FileLogger(configuration);

            for (int i = 0; i < 10000; i++) {
                logger.debug("Це повідомлення для рівня DEBUG.");
                logger.info("Це повідомлення для рівня INFO.");
            }
        } catch (IOException e) {
            System.err.println("Помилка під час створення логера: " + e.getMessage());
        } catch (FileMaxSizeReachedException e) {
            System.err.println("Досягнуто максимальний розмір файлу: " + e.getMessage());
            System.err.println("Поточний розмір файлу: " + e.getCurrentSize() + " байт");
        }
    }
}