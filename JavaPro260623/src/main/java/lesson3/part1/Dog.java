package lesson3.part1;

public class Dog implements Animals {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void swiming(int distance) {
        if (distance <= 10 && distance > 0) {
            System.out.println(name + " проплив " + distance + " м");
        } else {
            System.out.println(name + " стільки не пропливе!");
        }
    }

    @Override
    public void runing(int distance) {
        if (distance <= 500 && distance > 0) {
            System.out.println(name + " пробіг " + distance + " м");
        } else {
            System.out.println(name + " стільки не пробіжить!");
        }
    }
}
