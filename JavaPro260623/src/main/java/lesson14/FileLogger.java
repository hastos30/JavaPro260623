package main.java.lesson14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger {
    private FileLoggerConfiguration configuration;
    private FileWriter currentFileWriter;
    private int fileCounter;

    public FileLogger(FileLoggerConfiguration configuration) throws IOException {
        this.configuration = configuration;
        this.fileCounter = 0;
        createNewLogFile();
    }

    @Override
    public void debug(String message) throws FileMaxSizeReachedException, IOException {
        if (configuration.getCurrentLogLevel().includesDebug()) {
            log("[DEBUG] " + message);
        }
    }

    @Override
    public void info(String message) throws FileMaxSizeReachedException, IOException {
        if (configuration.getCurrentLogLevel().includesInfo()) {
            log("[INFO] " + message);
        }
    }

    private void log(String message) throws FileMaxSizeReachedException, IOException {
        if (currentFileWriter == null) {
            throw new IllegalStateException("Логер не ініціалізовано. Спробуйте створити новий екземпляр.");
        }

        File logFile = new File(currentFileWriter.toString());
        long currentFileSize = logFile.length();

        if (currentFileSize >= configuration.getMaxFileSize()) {
            currentFileWriter.close();
            createNewLogFile();
        }

        currentFileWriter.write(message + "\n");
        currentFileWriter.flush();
    }

    private void createNewLogFile() throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH_mm_ss");
        String timestamp = dateFormat.format(new Date());
        String logFileName = configuration.getLogFilePath() + "_" + timestamp + ".txt";

        currentFileWriter = new FileWriter(logFileName);
        fileCounter++;
    }
}