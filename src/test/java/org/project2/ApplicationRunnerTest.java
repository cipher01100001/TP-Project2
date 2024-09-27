package org.project2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationRunnerTest {
    private TestLogHandler testLogHandler;

    @BeforeEach
    void setUp() {
        testLogHandler = new TestLogHandler();
        Logger logger = Logger.getLogger(ApplicationRunner.class.getName());
        logger.addHandler(testLogHandler);
        logger.setUseParentHandlers(true);
    }

    @Test
    void run() {
        ApplicationRunner application = new ApplicationRunner();
        application.run();

        String expectedMessage = "The application has been executed successfully.";
        String actualLogs = testLogHandler.getCapturedLogs().trim();

        assertEquals(expectedMessage, actualLogs);
    }
}