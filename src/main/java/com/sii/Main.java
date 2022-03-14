package com.sii;

public class Main {
    public static void main(String[] args) {
        Action action = new Action();
        Car car = new Car();

        action.fillObjectCollection(Action.ObjectType.ALL);
        action.fillCarObject(car);
        action.filterCars(car);
    }
}