package com.sii;

import java.util.ArrayList;
import java.util.List;

public class Car extends Commons {

    private Producer producer;
    private boolean isAutomaticGear;
    private Market market;
    private String segment;
    private ArrayList<Dimension> dimension = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();

    public Car() {
    }

    public Car(Producer producer, boolean isAutomaticGear, Market market, String segment, ArrayList<Dimension> dimension) {
        this.producer = producer;
        this.isAutomaticGear = isAutomaticGear;
        this.market = market;
        this.segment = segment;
        this.dimension = dimension;
    }

    public void setDimension(ArrayList<Dimension> dimension) {
        this.dimension = dimension;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public Producer getProducer() {
        return producer;
    }

    public ArrayList<Dimension> getDimension() {
        return dimension;
    }

    public boolean isAutomaticGear() {
        return isAutomaticGear;
    }

    public Market getMarket() {
        return market;
    }

    public String setSegment(int segmentIndex) {
        List<String> segments = List.of("standard", "medium", "premium");
        validateSegmentIndex(segmentIndex, segments);
        return segments.get(segmentIndex);
    }

    @Override
    public String toString() {
        return "Producer: " + producer + "\nAutomatic: " + isAutomaticGear + "\nMarket: " + market + "\nSegment: "
                + segment + "\nDimension: " + dimension;
    }
}