package com.sii;

import java.util.List;

public class Market {
    public String name;
    public List<Country> countries;

    public Market() {
    }

    public Market(String name, List<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public String toString(){
        return name + " " + countries.toString();
    }
}
