package main.java.lesson5.experements;

public class Human implements Participant {
    private String name;
    private int stamina;

    public Human(String name) {
        this.name = name;
        this.stamina = 100;
    }

    @Override
    public void run() {
        System.out.println("Учасник " + name + " біжить!");
    }

    @Override
    public void jump() {
        System.out.println("Учасник " + name + " стрибає!");
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public void reduceStamina(int amount) {
        stamina -= amount * 2;
    }

    @Override
    public boolean canContinue() {
        return stamina > 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
