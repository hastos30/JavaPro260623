package main.java.lesson5.experements;

public class Wall implements Obstacle{
    private int height;

    public Wall(int height) {
        this.height = height;
    }


    @Override
    public void overcome(Participant participant) {
        participant.jump();
        System.out.println("Перестрибнув стіну висотою " + height + " метрів");
    }
}
