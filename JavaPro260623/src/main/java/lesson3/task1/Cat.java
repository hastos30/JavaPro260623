package lesson3.task1;

public class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    public void swiming(int distance) {
        System.out.println("кіт не вміє плавати");
    }

    @Override
    public void runing(int distance) {
        if (distance <= 200 && distance > 0) {
            System.out.println(name + " пробіг " + distance + " м");
        } else {
            System.out.println(name + " стільки не пробіжить!");
        }
    }
}
