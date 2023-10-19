package main.java.lesson5.experements;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Human("Іван"),
                new Cat("Мурзик"),
                new Robot("Робот-007")
        };

        Obstacle[] obstacles = new Obstacle[]{
                new Racetrack(20),
                new Wall(2),
                new Racetrack(10),
                new Wall(1),
                new Wall(2)
        };

        for (Participant participant : participants) {
            boolean isParticipantOut = false;
            System.out.println("Учасник " + participant.getName() + " має " + participant.getStamina()
                    + " витривалості.");
            for (Obstacle obstacle : obstacles) {
                if (participant.canContinue()) {
                    obstacle.overcome(participant);
                } else {
                    int requiredStamina = obstacle instanceof Racetrack ? ((Racetrack) obstacle).getLength()
                            : ((Wall) obstacle).getHeight();
                    System.out.println("Учаснику не вистачає " + (requiredStamina - participant.getStamina())
                            + " витривалості ");
                    System.out.println("Учасник " + participant.getName() + " вийшов з гонки.");
                    isParticipantOut = true;
                    break;
                }
            }
            if (!isParticipantOut) {
                System.out.println("Учасник " + participant.getName()
                        + " пройшов всі перешкоди і закінчив гонку! Залишок витривалості: " + participant.getStamina());
            }
            System.out.println();
        }
    }
}
