package main.java.lesson19;

class FuelTank {
    private int capacity;
    private int fuelLevel;

    public FuelTank(int capacity) {
        this.capacity = capacity;
        this.fuelLevel = 0;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void fillFuel(int amount) {
        if (fuelLevel + amount <= capacity) {
            fuelLevel += amount;
        } else {
            fuelLevel = capacity;
        }
    }

    public void useFuel(int amount) {
        if (fuelLevel - amount >= 0) {
            fuelLevel -= amount;
        } else {
            fuelLevel = 0;
        }
    }
}