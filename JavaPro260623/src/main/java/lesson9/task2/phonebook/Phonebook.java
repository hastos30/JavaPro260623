package main.java.lesson9.task2.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Record> records;

    public Phonebook() {
        records = new ArrayList<>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                foundRecords.add(record);
            }
        }
        return foundRecords.isEmpty() ? null : foundRecords;
    }
}
