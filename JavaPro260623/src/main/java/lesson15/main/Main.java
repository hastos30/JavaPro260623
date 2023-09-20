package main.java.lesson15.main;

import main.java.lesson15.decorators.TimerControlDecorator;
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

        TimerControlDecorator timedLight = new TimerControlDecorator(light1);
        TimerControlDecorator timedAC = new TimerControlDecorator(ac1);

        light1.turnOn();
        light1.setBrightness(70);

        ac1.turnOn();
        ac1.setTemperature(22);

        timedLight.scheduleTurnOn(5000);
        timedAC.scheduleTurnOff(10000);

        //для завершения программы
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

