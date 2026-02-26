package OOP.PresentsManagement.services;

import OOP.PresentsManagement.Sweet;

import java.util.Arrays;

public interface Present {
    public void addSweet(Sweet sweet) ;

    public double calculateTotalWeight() ;

    public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight);

    public Sweet[] getSweets();
}
