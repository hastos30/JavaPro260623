package main.java.lesson14;

public class FileLoggerConfiguration {
    private String logFilePath;
    private LoggingLevel currentLogLevel;
    private long maxFileSize;
    private String logFormat;

    public FileLoggerConfiguration(String logFilePath,
                                   LoggingLevel currentLogLevel,
                                   long maxFileSize,
                                   String logFormat) {
        this.logFilePath = logFilePath;
        this.currentLogLevel = currentLogLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public LoggingLevel getCurrentLogLevel() {
        return currentLogLevel;
    }

    public void setCurrentLogLevel(LoggingLevel currentLogLevel) {
        this.currentLogLevel = currentLogLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }

    public void setLogFormat(String logFormat) {
        this.logFormat = logFormat;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> lesson14.1
