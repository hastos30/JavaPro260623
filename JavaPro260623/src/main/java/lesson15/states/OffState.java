package main.java.lesson15.states;

import main.java.lesson15.devices.Device;

public class OffState implements DeviceState {
    @Override
    public void turnOn(Device device) {
        System.out.println("Включение " + device.getName() + ".");
        device.setState(new OnState());
    }

    @Override
    public void turnOff(Device device) {
        System.out.println(device.getName() + " выключен.");
    }
}
