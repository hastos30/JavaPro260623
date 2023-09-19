package main.java.lesson15.states;

import main.java.lesson15.devices.Device;

public interface DeviceState {
    void turnOn(Device device);
    void turnOff(Device device);
}