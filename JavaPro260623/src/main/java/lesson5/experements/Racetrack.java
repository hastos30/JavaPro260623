package main.java.lesson5.experements;

public class Racetrack implements Obstacle {
    private int length;

    public Racetrack(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Participant participant) {
        participant.run();
        System.out.println("Пройшов Бігова доріжка довжиною " + length + " метрів");
        participant.reduceStamina(length);
    }

    public int getLength() {
        return length;
    }
}
