package org.project2.model;

import java.time.LocalDateTime;

public class Realty {
    private final Double realtyPrice;
    private final Double realEstateArea;
    private final String address;
    private final LocalDateTime constructionDate;
    private final String realtyStatus;
    private final int stratum;
    private final String typeRealty;

    public Realty(Double realtyPrice, Double realEstateArea, String address, LocalDateTime constructionDate, String realtyStatus, int stratum, String typeRealty) {
        this.realtyPrice = realtyPrice;
        this.realEstateArea = realEstateArea;
        this.address = address;
        this.constructionDate = constructionDate;
        this.realtyStatus = realtyStatus;
        this.stratum = stratum;
        this.typeRealty = typeRealty;
    }

    public Double getRealtyPrice() { return realtyPrice; }
    public Double getRealEstateArea() { return realEstateArea; }
    public String getAddress() { return address; }
    public LocalDateTime getConstructionDate() { return constructionDate; }
    public String getRealtyStatus() { return realtyStatus; }
    public int getStratum() { return stratum; }
    public String getTypeRealty() { return typeRealty; }
}