package main.java.lesson15.decorators;

import main.java.lesson15.devices.Device;
import main.java.lesson15.observers.DeviceObserver;

import java.util.Timer;
import java.util.TimerTask;

public class TimerControlDecorator implements Device, DeviceObserver {
    private Device device;
    private Timer timer;

    public TimerControlDecorator(Device device) {
        this.device = device;
        this.timer = new Timer();
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void setState(main.java.lesson15.states.DeviceState state) {
        device.setState(state);
    }

    @Override
    public String getName() {
        return device.getName();
    }

    @Override
    public void setTemperature(int temperature) {
        device.setTemperature(temperature);
    }

    @Override
    public void setBrightness(int brightness) {
        device.setBrightness(brightness);
    }

    public void scheduleTurnOn(int delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                turnOn();
            }
        }, delay);
    }

    public void scheduleTurnOff(int delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                turnOff();
            }
        }, delay);
    }

    @Override
    public void update(Device device) {
        System.out.println("Уведомление: " + device.getName() + " изменил состояние.");
    }
}
