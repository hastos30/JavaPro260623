package lesson5.figures;

public class Circle implements Figure{

    private double Pi = 3.14;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Pi * radius * radius;
    }
}
