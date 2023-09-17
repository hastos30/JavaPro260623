package main.java.lesson14;

import java.io.*;

public interface Logger {
    void debug(String message) throws FileMaxSizeReachedException, IOException;
    void info(String message) throws FileMaxSizeReachedException, IOException;
}