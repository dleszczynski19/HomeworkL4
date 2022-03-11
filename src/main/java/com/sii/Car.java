package com.sii;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Car {

    private Producer producer;
    private boolean isAutomaticGear;
    private Market market;
    private String segment; //standard, medium, premium
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

    public String getSegment() {
        return segment;
    }

    public String setSegment(int segmentIndex) { //TODO add validator
        List<String> segments = List.of("standard", "medium", "premium");
        return segments.get(segmentIndex);
    }

    public void setDimension(ArrayList<Dimension> dimension, int firstDim, int secondDim, int thirdDim) {

        this.dimension.add(dimension.get(firstDim));
        this.dimension.add(dimension.get(secondDim));
        this.dimension.add(dimension.get(thirdDim));
    }

    @Override
    public String toString(){
        return "Producer: " + producer + "\nAutomatic: " + isAutomaticGear + "\nMarket: " + market + "\nSegment: "
                + segment + "\nDimension: " + dimension;
    }
}
