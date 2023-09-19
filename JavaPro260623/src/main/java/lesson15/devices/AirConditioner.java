package main.java.lesson15.devices;

import main.java.lesson15.states.OffState;
import main.java.lesson15.states.DeviceState;

public class AirConditioner implements Device {
    private String name;
    private DeviceState state;
    private int temperature;

    public AirConditioner(String name) {
        this.name = name;
        this.state = new OffState();
    }

    @Override
    public void turnOn() {
        state.turnOn(this);
    }

    @Override
    public void turnOff() {
        state.turnOff(this);
    }

    @Override
    public void setState(DeviceState state) {
        this.state = state;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Установить температуру для " + getName() + " на " + temperature + "°C.");
    }

    @Override
    public void setBrightness(int brightness) {
        System.out.println("Невозможно установить яркость для " + getName()
                + ". Это устройство не поддерживает регулировку яркости.");
    }
}