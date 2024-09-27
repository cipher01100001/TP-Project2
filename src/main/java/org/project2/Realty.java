package org.project2;

import java.time.LocalDateTime;

public record Realty(Double realtyPrice, Double realEstateArea, String address, LocalDateTime constructionDate, String realtyStatus, int stratum) { }