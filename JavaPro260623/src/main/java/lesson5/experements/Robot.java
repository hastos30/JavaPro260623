package main.java.lesson5.experements;

public class Robot implements Participant {
    private String name;
    private int stamina;

    public Robot(String name) {
        this.name = name;
        this.stamina = 120;
    }

    @Override
    public void run() {
        System.out.println("Учасник " + name + " (Robot) біжить!");
    }

    @Override
    public void jump() {
        System.out.println("Учасник " + name + " (Robot) стрибає!");
    }

    @Override
    public int getStamina() {
        return stamina;
    }

    @Override
    public void reduceStamina(int amount) {
        stamina -= amount * 4;
    }

    @Override
    public boolean canContinue() {
        return stamina > 0 ;
    }

    @Override
    public String getName() {
        return name;
    }
}