package org.project2.repository;

import org.project2.Realty;
import org.project2.repository.impl.RealtyRepositoryFileBased;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RealtyRepositoryTest {

    RealtyRepository realtyRepository = new RealtyRepositoryFileBased();

    @org.junit.jupiter.api.Test
    void when_realties_are_searched_by_address_results_returnerd_succesfully() {
        var realties = realtyRepository.findByAddress("Cr 23 #45-67");
        assertNotNull(realties);
        assertFalse(realties.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void when_realty_is_added_retunerd_succesfully() {
        Realty newRealty = new Realty(
                690000D,
                95D,
                "Cl 32 #50-22",
                LocalDateTime.now(),
                "Available",
                5
        );
        var realtyAdded = realtyRepository.addRealty(newRealty);
        assertTrue(realtyAdded);
    }

}