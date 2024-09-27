package org.project2;

import java.util.logging.Logger;

public class ApplicationRunner {
    protected static final Logger logger = Logger.getLogger(ApplicationRunner.class.getName());

    void run() {
        logger.info("The application has been executed successfully.");
    }
}