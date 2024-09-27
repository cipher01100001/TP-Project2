package org.project2.repository.impl;

import org.project2.Realty;
import org.project2.exceptions.RealtyAddressNotFoundException;
import org.project2.exceptions.RealtyStatusNotFoundException;
import org.project2.exceptions.RealtyStratumNotFoundException;
import org.project2.repository.RealtyRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

public class RealtyRepositoryFileBased implements RealtyRepository {
    private static final Logger logger = Logger.getLogger(RealtyRepositoryFileBased.class.getName());


    private List<Realty> realties = null;
    public RealtyRepositoryFileBased(){
        realties =  readRealties();
    }

    private List<Realty> readRealties(){
        Path pathFile = Paths.get( "./data/realties.txt" );

        List<Realty> realtiesList;

        logger.info("Starting to read clients from file: " + pathFile.toAbsolutePath());

        try (BufferedReader reader = Files.newBufferedReader( pathFile )) {
            realtiesList = reader.lines().map( this::build ).toList();
            logger.info("Finished reading realties. Total realties read: " + realtiesList.size());
        }catch (IOException e) {
            logger.severe("Error reading realties from file " + e);
            throw new RuntimeException( e );
        }
        return realtiesList;
    }

    private Realty build(String text){
        String[] realtyArray = text.split( "," );
        return new Realty(
                Double.parseDouble(realtyArray[0].trim()),
                Double.parseDouble(realtyArray[1].trim()),
                realtyArray[2].trim(),
                LocalDateTime.parse(realtyArray[3].trim()),
                realtyArray[4].trim(),
                Integer.parseInt(realtyArray[5].trim())
        );
    }

    @Override
    public List<Realty> findByAddress(String address) throws RealtyAddressNotFoundException {
        List<Realty> matchingRealties = realties.stream()
                .filter(realty -> realty.address().equalsIgnoreCase(address))
                .toList();

        if (matchingRealties.isEmpty()) {
            throw new RealtyAddressNotFoundException("No realties found with address: " + address);
        }
        return matchingRealties;
    }

    @Override
    public List<Realty> findByStratum(int stratum) throws RealtyStratumNotFoundException {
        return List.of();
    }

    @Override
    public List<Realty> findByRealtyStatus(String realtyStatus) throws RealtyStatusNotFoundException {
        return List.of();
    }
}