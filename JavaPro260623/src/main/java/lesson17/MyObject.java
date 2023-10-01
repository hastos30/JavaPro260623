package main.java.lesson17;

import java.io.Serializable;

class MyObject implements Serializable {
    private String message;

    public MyObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
