package com.sii;

import java.util.ArrayList;
import java.util.List;

public class Commons {
    public static final String colorReset = "\u001B[0m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorBlue = "\u001B[34m";

    public void validateProducerIndex(Action action, int index) {
        if (action.getProducers().size() <= index) throw new AssertionError("Wrong index (" + index +
                ") of producer. Maximum allowable index is " + (action.getProducers().size() - 1));
    }

    public void validateMarketIndex(Action action, int index) {
        if (action.getMarkets().size() <= index) throw new AssertionError("Wrong index (" + index +
                ") of market. Maximum allowable index is " + (action.getMarkets().size() - 1));
    }

    public void validateSegmentIndex(int index, List<String> list) {
        if (list.size() <= index) throw new AssertionError("Wrong index (" + index +
                ") of segment. Maximum allowable index is " + (list.size() - 1));
    }

    public void validateDimensionIndex(int index, ArrayList<Dimension> dimensions) {
        if (dimensions.size() <= index) throw new AssertionError("Wrong index (" + index +
                ") of dimension. Maximum allowable index is " + (dimensions.size() - 1));
    }
}