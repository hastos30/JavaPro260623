package main.java.lesson14;

public enum LoggingLevel {
    INFO, DEBUG;

    public boolean includesInfo() {
        return this == INFO || this == DEBUG;
    }

    public boolean includesDebug() {
        return this == DEBUG;
    }
}