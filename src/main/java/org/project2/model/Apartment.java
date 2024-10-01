package org.project2.model;

import java.time.LocalDateTime;

public class Apartment extends Realty {
    private final int floorNumber;

    public Apartment(Double realtyPrice, Double realEstateArea, String address, LocalDateTime constructionDate, String realtyStatus, int stratum, String typeRealty, int floorNumber) {
        super(realtyPrice, realEstateArea, address, constructionDate, realtyStatus, stratum, typeRealty);
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}