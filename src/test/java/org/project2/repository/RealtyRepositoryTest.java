package org.project2.repository;

import org.project2.model.Apartment;
import org.project2.repository.impl.RealtyRepositoryFileBased;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Apartment newRealty = new Apartment(
                690000D,
                95D,
                "Cl 32 #50-22",
                LocalDateTime.now(),
                "Available",
                5,
                "Apartment",
                5
        );
        var realtyAdded = realtyRepository.addRealty(newRealty);
        assertTrue(realtyAdded);
        Path filePath = Paths.get("./data/realtiescopy.txt");
        assertTrue(Files.exists(filePath), "El archivo debería existir.");
        try {
            String content = Files.readString(filePath);
            assertTrue(content.contains("Cl 32 #50-22"), "El archivo debería contener la dirección del nuevo realty.");
        } catch (IOException e) {
            fail("Error al leer el archivo: " + e.getMessage());
        }
    }
    @org.junit.jupiter.api.Test
    void when_realties_are_searched_by_stratum_results_returnerd_succesfully() {
        var realties = realtyRepository.findByStratum(3);
        assertNotNull(realties);
        assertFalse(realties.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void when_realties_are_searched_by_realtyStatus_results_returnerd_succesfully() {
        var realties = realtyRepository.findByRealtyStatus("Sold");
        assertNotNull(realties);
        assertFalse(realties.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testSaveRealtiesToFile() {
        String filePaths = "./data/realtiescopy.txt"; 

        try {
            realtyRepository.saveRealtiesToFile(filePaths);
            Path path = Paths.get(filePaths);
            assertTrue(Files.exists(path), "El archivo debería haberse creado exitosamente.");
            System.out.println("El archivo se ha creado correctamente en: " + filePaths);

        } catch (IOException e) {
            fail("Error al guardar realties en el archivo: " + e.getMessage());
        }
    }
}