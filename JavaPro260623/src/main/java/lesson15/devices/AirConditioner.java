package main.java.lesson15.devices;

import main.java.lesson15.observers.DeviceObservable;
import main.java.lesson15.observers.DeviceObserver;
import main.java.lesson15.states.OffState;
import main.java.lesson15.states.DeviceState;

import java.util.ArrayList;
import java.util.List;

public class AirConditioner implements Device, DeviceObservable {
    private String name;
    private DeviceState state;
    private int temperature;

    private List<DeviceObserver> observers;

    public AirConditioner(String name) {
        this.name = name;
        this.state = new OffState();
        observers = new ArrayList<>();
    }

    @Override
    public void turnOn() {
        state.turnOn(this);
        notifyObservers();
    }

    @Override
    public void turnOff() {
        state.turnOff(this);
        notifyObservers();
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
    public void addObserver(DeviceObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (DeviceObserver observer : observers) {
            observer.update(this);
        }
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