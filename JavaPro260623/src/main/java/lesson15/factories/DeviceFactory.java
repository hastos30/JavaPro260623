package main.java.lesson15.factories;

import main.java.lesson15.devices.Device;

public interface DeviceFactory {
    Device createDevice(String name);
}