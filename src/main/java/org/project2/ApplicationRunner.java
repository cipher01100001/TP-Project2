package org.project2;

import java.io.IOException;
import java.util.logging.Logger;
import org.project2.repository.impl.RealtyRepositoryFileBased;

public class ApplicationRunner {
    protected static final Logger logger = Logger.getLogger(ApplicationRunner.class.getName());

    void run() {
        logger.info("The application has been executed successfully.");
    }

    public static void main(String[] args) {
        RealtyRepositoryFileBased repository = new RealtyRepositoryFileBased();
        String filePaths = "./data/realtiescopy.txt"; // Archivo donde se guardará la información

        try {
            repository.saveRealtiesToFile(filePaths);
            System.out.println("Realties saved to file: " + filePaths);
        } catch (IOException e) {
            System.err.println("Error saving realties to file: " + e.getMessage());
        }
    }
}