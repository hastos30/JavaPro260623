package lesson5.experiments;

public class Racetrack implements Obstacle{

    private int length;

    public Racetrack(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Participant participant) {
        participant.run();
        System.out.println("Пройшов " + length + " метрів по біговій доріжці");
    }
}
