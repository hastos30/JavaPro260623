package lesson3.task1;

public abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void swiming(int distance);

    public abstract void runing(int distance);
}
