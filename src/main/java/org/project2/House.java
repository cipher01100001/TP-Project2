package org.project2;

import java.time.LocalDateTime;

public class House extends Realty {
    private final int numberOfFloors;

    public House(Double realtyPrice, Double realEstateArea, String address, LocalDateTime constructionDate, String realtyStatus, int stratum, String typeRealty, int numberOfFloors) {
        super(realtyPrice, realEstateArea, address, constructionDate, realtyStatus, stratum, typeRealty);
        this.numberOfFloors = numberOfFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
}