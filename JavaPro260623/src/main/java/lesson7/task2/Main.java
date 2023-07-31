package main.java.lesson7.task2;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);

        System.out.println("Вес коробки яблок: " + appleBox.getWeight());
        System.out.println("Вес коробки апельсин: " + orangeBox.getWeight());

        System.out.println("Являются ли коробки одинаковыми по весу? " + appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        System.out.println("Обьеденение коробки appleBox2 в appleBox...");
        appleBox.merge(appleBox2);

        System.out.println("Вес коробки AppleBox после слияния: " + appleBox.getWeight());
        System.out.println("Вес коробки AppleBox2 после слияния: " + appleBox2.getWeight());
    }
}
