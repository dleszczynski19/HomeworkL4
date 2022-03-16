package com.sii;

import data.DataGenerator;

public class Main {
    public static void main(String[] args) {
        DataGenerator action = new DataGenerator();
        Car car = new Car();

        action.fillObjectCollection(DataGenerator.ObjectType.ALL);
        action.fillCarObject(car);
        action.printCars(action.filterCars(car, "BmW", true, 300));
    }
}