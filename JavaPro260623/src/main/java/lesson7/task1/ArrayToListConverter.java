package main.java.lesson7.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToListConverter {
    public static <T> List<T> toList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
