package com.sii;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car car = new Car();

        addCar(car, new Producer("Toyota", "Corolla"), true,
                new Market("cargo", List.of(new Country("Poland", "P".charAt(0)),
                        new Country("Spain", "S".charAt(0)),
                        new Country("Belgium", "B".charAt(0)))), car.setSegment(0),
                (addDimension(car, 10, 15, 20)));

        addCar(car, new Producer("Honda", "Civic"), true,
                new Market("cargo", List.of(new Country("Germany", "G".charAt(0)),
                        new Country("Poland", "P".charAt(0)),
                        new Country("Belgium", "B".charAt(0)))), car.setSegment(1),
                (addDimension(car, 10, 15, 20)));

        addCar(car, new Producer("Mazda", "6"), false,
                new Market("cargo", List.of(new Country("France", "F".charAt(0)),
                        new Country("Poland", "P".charAt(0)),
                        new Country("Spain", "S".charAt(0)))), car.setSegment(2),
                (addDimension(car, 10, 15, 20)));

        for (Car carCar : car.getCars()) {
            System.out.println("Model: " + carCar.getProducer().getModel());
            System.out.println("Type: " + carCar.getProducer().getType());
            System.out.println("Country: " + carCar.getMarket().getName());
            carCar.getMarket().getCountries();
            System.out.println("Automat: " + carCar.isAutomaticGear());
            System.out.println("Segment: " + carCar.getSegment());
            System.out.println("#################");
        }
    }

    public static void addCar(Car car, Producer producer, boolean isAutomaticGear, Market market, String segment,
                              ArrayList<Dimension> dimension) {

        car.getCars().add(new Car(producer, isAutomaticGear, market, segment, dimension));
    }

    public static ArrayList<Dimension> addDimension(Car car, int height, int weight, int tankCapacity) {
        car.getDimension().add(new Dimension(height, weight, tankCapacity));
        return car.getDimension();
    }
}