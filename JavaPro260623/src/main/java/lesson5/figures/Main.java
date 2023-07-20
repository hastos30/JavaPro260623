package main.java.lesson5.figures;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(10);
        Triangle triangle1 = new Triangle(3,5);
        Square square1 = new Square(4);

        System.out.println("Площа кола: " + circle1.area());
        System.out.println("Площа трикутника: " + triangle1.area());
        System.out.println("Площа квадрата: " + square1.area());

        Figure [] figures = new Figure[]{
                circle1,
                triangle1,
                square1
        };
        double totalArea = getTotalArea(figures);
        System.out.println("Сумарна площа всіх фігур: " + totalArea);
    }

    public static double getTotalArea(Figure[] figures){
        double totalArea = 0;
        for(Figure figure : figures){
            totalArea += figure.area();
        }

        return totalArea;
    }
}
