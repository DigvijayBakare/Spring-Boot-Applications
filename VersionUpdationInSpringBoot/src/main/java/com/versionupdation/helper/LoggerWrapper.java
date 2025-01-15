package com.versionupdation.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerWrapper {
    private final Logger logger;        // declaring a logger

    // Constructor to create object of logger
    private LoggerWrapper(Class<?> clazz) {
        this.logger = LogManager.getLogger(clazz);
    }

    // Factory method for getting a logger instance
    public static LoggerWrapper getLogger(Class<?> clazz) {
        return new LoggerWrapper(clazz);
    }

    // Logging methods
    public void debug(String message) {
        logger.debug(message);
    }

    public void debug(String message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, Throwable throwable) {
        logger.info(message, throwable);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void warn(String message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public void fatal(String message) {
        logger.fatal(message);
    }

    public void fatal(String message, Throwable throwable) {
        logger.fatal(message, throwable);
    }
}