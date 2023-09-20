package main.java.lesson15.observers;

public interface DeviceObservable {
    void addObserver(DeviceObserver observer);
    void removeObserver(DeviceObserver observer);
    void notifyObservers();
}