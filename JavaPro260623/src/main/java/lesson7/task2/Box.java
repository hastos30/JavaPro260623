package main.java.lesson7.task2;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final int capacity;
    private final List<T> fruits;

    Box(int capacity) {
        this.capacity = capacity;
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        if (fruits.size() < capacity) {
            fruits.add(fruit);
        } else {
            System.out.println("Коробка заполнена. Невозможно добавить еще фруктов.");
        }
    }

    public void addFruits(List<T> newFruits) {
        int spaceLeft = capacity - fruits.size();
        if (spaceLeft >= newFruits.size()) {
            fruits.addAll(newFruits);
        } else {
            System.out.println("Недостаточно места в коробке для добавления всех фруктов.");
        }
    }

    public float getWeight() {
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void merge(Box<T> otherBox) {
        for (T fruit : otherBox.fruits) {
            addFruit(fruit);
        }
        otherBox.fruits.clear();
    }
}
