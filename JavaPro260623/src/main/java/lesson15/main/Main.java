package main.java.lesson15.main;

import main.java.lesson15.factories.AirConditionerFactory;
import main.java.lesson15.factories.LightFactory;
import main.java.lesson15.devices.Device;
import main.java.lesson15.factories.DeviceFactory;

public class Main {
    public static void main(String[] args) {
        DeviceFactory lightFactory = new LightFactory();
        DeviceFactory acFactory = new AirConditionerFactory();

        Device light1 = lightFactory.createDevice("свет в гостиной");
        Device ac1 = acFactory.createDevice("кондиционер в спальне");

        light1.turnOn();
        light1.setBrightness(70);

        ac1.turnOn();
        ac1.setTemperature(22);

        light1.turnOff();
        ac1.turnOff();
    }
}
