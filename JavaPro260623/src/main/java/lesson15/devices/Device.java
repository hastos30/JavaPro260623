package main.java.lesson15.devices;

import main.java.lesson15.states.DeviceState;

public interface Device {
    void turnOn();
    void turnOff();
    void setState(DeviceState state);
    String getName();
    void setTemperature(int temperature);
    void setBrightness(int brightness);
}