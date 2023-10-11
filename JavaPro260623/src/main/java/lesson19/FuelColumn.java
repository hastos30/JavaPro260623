package main.java.lesson19;

class FuelColumn {
    private String name;
    private FuelTank fuelTank;

    public FuelColumn(String name, FuelTank fuelTank) {
        this.name = name;
        this.fuelTank = fuelTank;
    }

    public String getName() {
        return name;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }
}
