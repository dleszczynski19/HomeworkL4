package com.sii;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Action {
    private ArrayList<Producer> producers = new ArrayList<>();
    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Dimension> dimensions = new ArrayList<>();
    private List<Market> markets = new ArrayList<>();

    public enum ObjectType {
        PRODUCER, DIMENSION, COUNTRY, MARKET
    }

    public ArrayList<Country> getCountries() {
        return countries;
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

    public void fillObjectList(ObjectType objectType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonPath = "src/main/resources/";
            switch (objectType) {
                case COUNTRY:
                    countries = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get(jsonPath + "country.json")
                            .toFile(), Country[].class)));
//                    System.out.println("COUNTRIES:");
//                    countries.forEach(System.out::println);
//                    System.out.println("##########");
                    break;
                case PRODUCER:
                    producers = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get(jsonPath + "producer.json")
                            .toFile(), Producer[].class)));
//                    System.out.println("Producers:");
//                    producers.forEach(System.out::println);
//                    System.out.println("##########");
                    break;
                case DIMENSION:
                    dimensions = new ArrayList<>(Arrays.asList(mapper.readValue(Paths.get("src/main/resources/dimension.json")
                            .toFile(), Dimension[].class)));
//                    System.out.println("Dimensions:");
//                    dimensions.forEach(System.out::println);
//                    System.out.println("##########");
                    break;
                case MARKET:
                    markets.add(new Market("business", List.of(countries.get(0), countries.get(1), countries.get(2))));
                    markets.add(new Market("cargo", List.of(countries.get(4), countries.get(2), countries.get(2))));
                    markets.add(new Market("taxi", List.of(countries.get(3), countries.get(1), countries.get(0))));
                    markets.add(new Market("bus", List.of(countries.get(1), countries.get(3), countries.get(2))));
//                    System.out.println("Markets:");
//                    markets.forEach(System.out::println);
//                    System.out.println("##########");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
