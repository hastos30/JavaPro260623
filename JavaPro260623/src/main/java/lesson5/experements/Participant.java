package main.java.lesson5.experements;

public interface Participant {
    void run();
    void jump();
    int getStamina();
    void reduceStamina(int amount);
    boolean canContinue();
    String getName();
}
