package main.java.lesson5.figures;

public class Square implements Figure{

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(side,2);
    }
}
