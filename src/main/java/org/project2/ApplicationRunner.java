package org.project2;

import java.io.IOException;
import java.util.logging.Logger;
import org.project2.repository.impl.RealtyRepositoryFileBased;

public class ApplicationRunner {
    protected static final Logger logger = Logger.getLogger(ApplicationRunner.class.getName());

    void run() {
        logger.info("The application has been executed successfully.");
    }
}