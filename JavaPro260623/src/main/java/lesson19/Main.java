package main.java.lesson19;

public class Main {
    public static void main(String[] args) {
        FuelStation station = new FuelStation();

        Car car1 = new Car("Car1", station.getPetrolColumn().getFuelTank());
        Car car2 = new Car("Car2", station.getDieselColumn().getFuelTank());

        station.enqueueCar(car1);
        station.enqueueCar(car2);

        station.startFueling();
    }
}
