package main.java.lesson15.states;

import main.java.lesson15.devices.Device;

public class OnState implements DeviceState {
    @Override
    public void turnOn(Device device) {
        System.out.println(device.getName() + " уже включен.");
    }

    @Override
    public void turnOff(Device device) {
        System.out.println("Выключить " + device.getName() + ".");
        device.setState(new OffState());
    }
}
