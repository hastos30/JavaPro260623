package main.java.lesson14;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileLoggerConfiguration fileLoggerConfig = new FileLoggerConfiguration(
                    "Log", LoggingLevel.DEBUG, 1024, "yyyy-MM-dd HH:mm:ss"
            );

            Logger fileLogger = new FileLogger(fileLoggerConfig);

            for (int i = 0; i < 10000; i++) {
                fileLogger.debug("Це повідомлення для рівня DEBUG.");
                fileLogger.info("Це повідомлення для рівня INFO.");
            }

            Logger consoleLogger = new ConsoleLogger();

            for (int i = 0; i < 10; i++) {
                consoleLogger.debug("Це повідомлення для рівня DEBUG (консоль).");
                consoleLogger.info("Це повідомлення для рівня INFO (консоль).");
            }
        } catch (IOException e) {
            System.err.println("Помилка під час створення логера: " + e.getMessage());
        } catch (FileMaxSizeReachedException e) {
            System.err.println("Досягнуто максимальний розмір файлу: " + e.getMessage());
            System.err.println("Поточний розмір файлу: " + e.getCurrentSize() + " байт");
        }
    }
}