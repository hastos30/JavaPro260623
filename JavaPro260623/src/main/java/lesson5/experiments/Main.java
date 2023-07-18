package lesson5.experiments;

public class Main {
    public static void main(String[] args) {
        Participant [] participants = new Participant[]{
                new Human(),
                new Cat(),
                new Robot()
        };

        Obstacle[] obstacles = new Obstacle[]{
                new Racetrack(100),
                new Wall(1)
        };

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles){
                obstacle.overcome(participant);
            }
        }
    }
}
