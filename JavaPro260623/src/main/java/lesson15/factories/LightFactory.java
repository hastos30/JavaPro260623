package main.java.lesson15.factories;

import main.java.lesson15.devices.Device;
import main.java.lesson15.devices.Light;

public class LightFactory implements DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new Light(name);
    }
}
