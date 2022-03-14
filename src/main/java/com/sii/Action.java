package com.sii;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Action extends Commons {
    private ArrayList<Producer> producers = new ArrayList<>();
    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Dimension> dimensions = new ArrayList<>();
    private final List<Market> markets = new ArrayList<>();

    public enum ObjectType {
        PRODUCER, DIMENSION, COUNTRY, MARKET, ALL
    }

    public ArrayList<Producer> getProducers() {
        return producers;
    }

    public ArrayList<Dimension> getDimensions() {
        return dimensions;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public void fillObjectCollection(ObjectType objectType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonPath = "src/main/resources/";
            switch (objectType) {
                case COUNTRY:
                    countries = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get(jsonPath + "country.json")
                            .toFile(), Country[].class)));
                    System.out.println(colorGreen + countries.size() + " countries added." + colorReset);
                    break;
                case PRODUCER:
                    producers = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get(jsonPath + "producer.json")
                            .toFile(), Producer[].class)));
                    System.out.println(colorGreen + producers.size() + " producers added." + colorReset);
                    break;
                case DIMENSION:
                    dimensions = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get("src/main/resources/dimension.json")
                            .toFile(), Dimension[].class)));
                    System.out.println(colorGreen + dimensions.size() + " dimensions array added." + colorReset);
                    break;
                case MARKET:
                    markets.add(new Market("business", List.of(countries.get(0), countries.get(1), countries.get(2))));
                    markets.add(new Market("cargo", List.of(countries.get(4), countries.get(2), countries.get(3))));
                    markets.add(new Market("taxi", List.of(countries.get(3), countries.get(1), countries.get(0))));
                    markets.add(new Market("transport", List.of(countries.get(1), countries.get(3), countries.get(2))));
                    markets.add(new Market("bus", List.of(countries.get(1), countries.get(4), countries.get(0))));
                    System.out.println(colorGreen + markets.size() + " markets added." + colorReset);
                    break;
                case ALL:
                    fillObjectCollection(Action.ObjectType.PRODUCER);
                    fillObjectCollection(Action.ObjectType.COUNTRY);
                    fillObjectCollection(Action.ObjectType.DIMENSION);
                    fillObjectCollection(Action.ObjectType.MARKET);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fillCarObject(Car car) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode carsJson = null;
        try {
            carsJson = objectMapper.readTree(new File("src/main/resources/car.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Objects.requireNonNull(carsJson).size(); i++) {
            JsonNode jsonPath = carsJson.get(i);
            addCar(car, jsonPath.get("producerIndex").asInt(), jsonPath.get("isAutomatic").asBoolean(),
                    jsonPath.get("marketIndex").asInt(), jsonPath.get("segmentIndex").asInt(),
                    setDimensionsArray(jsonPath));
        }
        System.out.println(colorGreen + carsJson.size() + " cars added." + colorReset);
    }

    public int[] setDimensionsArray(JsonNode jsonNode) {
        int[] dimensionsArray = new int[jsonNode.get("dimensions").size()];
        for (int i = 0; i < jsonNode.get("dimensions").size(); i++) {
            dimensionsArray[i] = jsonNode.get("dimensions").get(i).asInt();
        }
        return dimensionsArray;
    }

    public void addCar(Car car, int producerIndex, boolean isAutomatic, int marketIndex, int segmentIndex,
                       int[] dimensions) {
        validateProducerIndex(this, producerIndex);
        validateMarketIndex(this, marketIndex);
        Producer producer = new Producer((getProducers().get(producerIndex).getModel()), getProducers()
                .get(producerIndex).getType());
        Market market = new Market(getMarkets().get(marketIndex).getName(), getMarkets()
                .get(marketIndex).getCountries());
        Dimension dimension;
        for (int index : dimensions) {
            validateDimensionIndex(index, getDimensions());
            dimension = new Dimension(getDimensions().get(index).getHeight(),
                    getDimensions().get(index).getWidth(),
                    getDimensions().get(index).getTankCapacity());
            car.getDimension().add(dimension);
        }
        car.getCars().add(new Car(producer, isAutomatic, market, car.setSegment(segmentIndex), car.getDimension()));
        car.setDimension(new ArrayList<>());
    }

    public void filterCars(Car car) {
        System.out.println("Odpowiedź:" + colorBlue);
        car.getCars().stream()
                .filter(p -> p.getProducer().getModel().equals("BMW"))
                .filter(Car::isAutomaticGear)
                .filter(car1 -> car1.getDimension().get(0).getTankCapacity() > 300 ||
                        car1.getDimension().get(1).getTankCapacity() > 300 ||
                        car1.getDimension().get(2).getTankCapacity() > 300)
                .map(Car::getMarket)
                .map(Market::getCountries)
                .forEach(System.out::println);
    }
}