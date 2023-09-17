package main.java.lesson14;

public class FileMaxSizeReachedException extends Exception {
    private String filePath;
    private long maxFileSize;
    private long currentSize;

    public FileMaxSizeReachedException(String filePath, long maxFileSize, long currentSize) {
        super("Досягнуто максимальний розмір файлу "
                + filePath + ". Максимальний розмір: "
                + maxFileSize + " байт. Поточний розмір: "
                + currentSize + " байт");
        this.filePath = filePath;
        this.maxFileSize = maxFileSize;
        this.currentSize = currentSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public long getCurrentSize() {
        return currentSize;
    }
}
