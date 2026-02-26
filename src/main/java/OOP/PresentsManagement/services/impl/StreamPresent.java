package OOP.PresentsManagement.services.impl;

import OOP.PresentsManagement.Sweet;
import OOP.PresentsManagement.services.Present;

import java.util.Arrays;
import java.util.Objects;

public class StreamPresent implements Present {
    private static final int DEFAULT_GIFT_CAPACITY = 10;
    private Sweet[] sweets;
    private int lastIndexAdded;

    {
        sweets = new Sweet[DEFAULT_GIFT_CAPACITY];
    }


    @Override
    public void addSweet(Sweet sweet) {
        if (sweet == null) {
            return;
        }
        if (sweets.length <= lastIndexAdded) {
            sweets = Arrays.copyOf(sweets, sweets.length << 1);
        }
        sweets[lastIndexAdded++] = sweet;
    }

    @Override
    public double calculateTotalWeight() {
        return Arrays.stream(sweets).filter(Objects::nonNull).mapToDouble(sweet -> sweet.getWeight()).sum();
    }

    @Override
    public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
        if (minSugarWeight < 0 || maxSugarWeight < 0 || maxSugarWeight < minSugarWeight) {
            return new Sweet[0];
        }
        return Arrays.stream(sweets)
                .filter(Objects::nonNull)
                .filter(sweet -> {
                    if (sweet.getSugarWeight() > minSugarWeight && sweet.getSugarWeight() < maxSugarWeight){
                        return true;
                    }else {
                        return false;
                    }
                }).toArray(Sweet[]::new);

    }

    @Override
    public Sweet[] getSweets() {
        return Arrays.stream(sweets).filter(Objects::nonNull).toArray(Sweet[]::new);
    }
}
