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
    import java.util.ArrayList;
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
                realtiesList = new ArrayList<>(reader.lines().map( this::build ).toList());
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
        public boolean addRealty(Realty newRealty) {
            if (newRealty == null) {
                logger.warning("Attempted to add a null realty.");
                throw new IllegalArgumentException("Realty cannot be null.");
            }

            String address = newRealty.address();
            if (address == null || address.isEmpty()) {
                logger.warning("Invalid address provided for realty: " + newRealty);
                throw new IllegalArgumentException("Realty must have a valid, non-empty address.");
            }

            double price = newRealty.realtyPrice();
            if (price <= 0) {
                logger.warning("Invalid price provided for realty: " + newRealty);
                throw new IllegalArgumentException("Realty must have a positive price.");
            }

            double area = newRealty.realEstateArea();
            if (area <= 0) {
                logger.warning("Invalid area provided for realty: " + newRealty);
                throw new IllegalArgumentException("Realty must have a positive area.");
            }

            int stratum = newRealty.stratum();
            if (stratum <= 0) {
                logger.warning("Invalid stratum provided for realty: " + newRealty);
                throw new IllegalArgumentException("Realty must have a positive stratum.");
            }

            realties.add(newRealty);
            logger.info("New realty added successfully: " + newRealty);
            return true;
        }

        @Override
        public List<Realty> findByAddress(String address) throws RealtyAddressNotFoundException {
            List<Realty> matchingRealties = new ArrayList<>();

            for (Realty realty : realties) {
                if (realty.address().equalsIgnoreCase(address)) {
                    matchingRealties.add(realty);
                }
            }

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