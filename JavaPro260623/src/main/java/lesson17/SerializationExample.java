package main.java.lesson17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class SerializationExample {
    public static void main(String[] args) {
        MyObject myObject = new MyObject("Hello, World!");

        // Серіалізація
        try {
            FileOutputStream fileOut = new FileOutputStream("serializedObject.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myObject);
            out.close();
            fileOut.close();
            System.out.println("Об'єкт серіалізовано і збережено в файлі 'serializedObject.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десеріалізація
        try {
            FileInputStream fileIn = new FileInputStream("serializedObject.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyObject deserializedObject = (MyObject) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Об'єкт десеріалізовано: " + deserializedObject.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        File sourceFile = new File("serializedObject.ser");
        File destinationDirectory = new File("JavaPro260623/src/main/java/lesson17/destinationDirectory");

        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdir();
        }

        File destinationFile = new File(destinationDirectory, "serializedObject.ser");

        try {
            Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл переміщено до нового місця.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}