package lesson3.part1;

public class Cat implements Animals {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void swiming(int distance) {
        System.out.println("кіт не вміє плавати");
    }

    @Override
    public void runing(int distance) {
        if (distance <= 200 && distance > 0){
            System.out.println(name + " пробіг " + distance + " м");
        } else {
            System.out.println(name + " стільки не пробіжить!");
        }
    }
}
