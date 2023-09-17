package main.java.lesson14;

import java.io.*;

public class ConsoleLogger implements Logger {
    @Override
    public void debug(String message) throws FileMaxSizeReachedException, IOException {
        System.out.println("[DEBUG] " + message);
    }

    @Override
    public void info(String message) throws FileMaxSizeReachedException, IOException {
        System.out.println("[INFO] " + message);
    }
}
