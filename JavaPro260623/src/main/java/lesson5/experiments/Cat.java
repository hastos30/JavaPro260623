package lesson5.experiments;

public class Cat implements Participant{
    @Override
    public void run() {
        System.out.println("Кіт біжить!");
    }

    @Override
    public void jump() {
        System.out.println("Кіт стрибає!");
    }
}
