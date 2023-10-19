package main.java.lesson14;

public class FileLoggerConfiguration {
    private String logFilePath;
    private LoggingLevel currentLogLevel;
    private long maxFileSize;
    private String logFormat;

    private String classNamePattern;
    private String timePattern;
    private String messageColorPattern;
    private String loggingLevelPattern;

    public FileLoggerConfiguration(String logFilePath,
                                   LoggingLevel currentLogLevel,
                                   long maxFileSize,

                                   String logFormat,
                                   String classNamePattern,
                                   String timePattern,
                                   String messageColorPattern,
                                   String loggingLevelPattern) {

                                   String logFormat) {
        this.logFilePath = logFilePath;
        this.currentLogLevel = currentLogLevel;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;

        this.classNamePattern = classNamePattern;
        this.timePattern = timePattern;
        this.messageColorPattern = messageColorPattern;
        this.loggingLevelPattern = loggingLevelPattern;
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


    public String getClassNamePattern() {
        return classNamePattern;
    }

    public void setClassNamePattern(String classNamePattern) {
        this.classNamePattern = classNamePattern;
    }

    public String getTimePattern() {
        return timePattern;
    }

    public void setTimePattern(String timePattern) {
        this.timePattern = timePattern;
    }

    public String getMessageColorPattern() {
        return messageColorPattern;
    }

    public void setMessageColorPattern(String messageColorPattern) {
        this.messageColorPattern = messageColorPattern;
    }

    public String getLoggingLevelPattern() {
        return loggingLevelPattern;
    }

    public void setLoggingLevelPattern(String loggingLevelPattern) {
        this.loggingLevelPattern = loggingLevelPattern;
    }
}