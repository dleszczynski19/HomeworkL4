package com.sii;

public class Country {
    String countryName;
    char countrySign;

    public Country() {
    }

    public Country(String countryName, char countrySign) {
        this.countryName = countryName;
        this.countrySign = countrySign;
    }

    public String getCountryName() {
        return countryName;
    }

    public char getCountrySign() {
        return countrySign;
    }

    @Override
    public String toString() {
        return countryName + " - " + countrySign;
    }
}