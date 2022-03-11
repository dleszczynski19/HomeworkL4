package com.sii;

public class Test {
    public static void main(String[] args) {
        Action action = new Action();
        Car car = new Car();

        action.fillObjectList(Action.ObjectType.PRODUCER);
        action.fillObjectList(Action.ObjectType.COUNTRY);
        action.fillObjectList(Action.ObjectType.DIMENSION);
        action.fillObjectList(Action.ObjectType.MARKET);
        addCar(action, car, 1, 2, 2);
        addCar(action, car, 2, 1, 0);
        car.getCars().stream()
                .filter(p -> p.getProducer().getModel().equals("BMW"))
                .filter(Car::isAutomaticGear)
                .map(Car::getMarket)
                .map(Market::getCountries)
                .forEach(System.out::println);
    }

    public static void addCar(Action action, Car car, int producerIndex, int marketIndex, int segmentIndex){

        Producer producer = new Producer((action.getProducers().get(producerIndex).getModel()), action.getProducers()
                .get(producerIndex).getType());
        Market market = new Market(action.getMarkets().get(marketIndex).getName(), action.getMarkets()
                .get(marketIndex).getCountries());
        car.setDimension(action.getDimensions(), 1, 2, 3);

        car.getCars().add(new Car(producer, true, market, car.setSegment(segmentIndex), car.getDimension()));
    }
}
