package main.java.lesson15.factories;

import main.java.lesson15.devices.AirConditioner;
import main.java.lesson15.devices.Device;

public class AirConditionerFactory implements DeviceFactory {
    @Override
    public Device createDevice(String name) {
        return new AirConditioner(name);
    }
}
