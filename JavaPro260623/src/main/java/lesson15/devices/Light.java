package main.java.lesson15.devices;

import main.java.lesson15.states.OffState;
import main.java.lesson15.states.DeviceState;

public class Light implements Device {
    private String name;
    private DeviceState state;
    private int brightness;

    public Light(String name) {
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
    public void setBrightness(int brightness) {
        this.brightness = brightness;
        System.out.println("Установить яркость для " + getName() + " на " + brightness + "%.");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Невозможно установить температуру для " + getName()
                + ". Это устройство не поддерживает контроль температуры.");
    }
}