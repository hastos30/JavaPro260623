package main.java.lesson5.experements;

public class Human implements Participant{
    @Override
    public void run() {
        System.out.println("Людина біжить!");
    }

    @Override
    public void jump() {
        System.out.println("Людина стрибає!");
    }
}
