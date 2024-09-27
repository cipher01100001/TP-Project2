package org.project2.repository;

import org.project2.repository.impl.RealtyRepositoryFileBased;

import static org.junit.jupiter.api.Assertions.*;

class RealtyRepositoryTest {

    RealtyRepository realtyRepository = new RealtyRepositoryFileBased();

    @org.junit.jupiter.api.Test
    void when_realties_are_searched_by_address_results_returnerd_succesfully() {
        var realties = realtyRepository.findByAddress("Cr 23 #45-67");
        assertNotNull(realties);
        assertFalse(realties.isEmpty());
    }

}