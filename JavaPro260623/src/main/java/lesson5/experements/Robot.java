package main.java.lesson5.experements;

public class Robot implements Participant{
    @Override
    public void run() {
        System.out.println("Робот біжить!");
    }

    @Override
    public void jump() {
        System.out.println("Робот стрибає!");
    }
}
