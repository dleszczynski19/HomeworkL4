package com.sii;

public class Producer {
    private String model;
    private String type;

    public Producer() {
    }

    public Producer(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return model + " " + type;
    }
}