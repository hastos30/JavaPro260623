package main.java.lesson7.task2;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        if(fruits.isEmpty() || fruits.get(0).getClass() == fruit.getClass()){
            fruits.add(fruit);
        } else {
            System.out.println("Не могу добавить "
                            + fruit.getClass().getSimpleName()
                            + " в ящик "
                            + fruits.get(0).getClass().getSimpleName());
        }
    }

    public void addFruits(List<T> newFruits){
        for(T fruit : newFruits){
            addFruit(fruit);
        }
    }

    public float getWeight(){
        float totalWeight = 0;
        for(T fruit : fruits){
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox){
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void merge(Box<T> otherBox){
        for(T fruit : otherBox.fruits){
            addFruit(fruit);
        }
        otherBox.fruits.clear();
    }
}
