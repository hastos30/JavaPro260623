package main.java.lesson19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FuelStation {
    private Queue<Car> carQueue = new LinkedList<>();
    private FuelColumn petrolColumn;
    private FuelColumn dieselColumn;
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public FuelStation() {
        FuelTank petrolTank = new FuelTank(10000);
        FuelTank dieselTank = new FuelTank(8000);
        petrolColumn = new FuelColumn("Petrol Column", petrolTank);
        dieselColumn = new FuelColumn("Diesel Column", dieselTank);
    }

    public FuelColumn getPetrolColumn() {
        return petrolColumn;
    }

    public FuelColumn getDieselColumn() {
        return dieselColumn;
    }

    public void enqueueCar(Car car) {
        carQueue.offer(car);
    }

    public Car dequeueCar() {
        return carQueue.poll();
    }

    public void startFueling() {
        executor.execute(() -> {
            while (true) {
                Car car = dequeueCar();
                if (car == null) {
                    break;
                }

                if (car.getFuelTank() == petrolColumn.getFuelTank()) {
                    fuelCar(petrolColumn, car);
                } else if (car.getFuelTank() == dieselColumn.getFuelTank()) {
                    fuelCar(dieselColumn, car);
                }
            }
        });

        executor.shutdown();
    }

    private void fuelCar(FuelColumn column, Car car) {
        synchronized (column) {
            FuelTank carFuelTank = car.getFuelTank();
            int availableFuel = column.getFuelTank().getFuelLevel();
            carFuelTank.fillFuel(availableFuel);
            column.getFuelTank().useFuel(availableFuel);
            System.out.println(car.getName() + " was refueled at " + column.getName());
        }
    }
}
