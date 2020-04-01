package com.hellofresh.challenge.utilities;

import io.qameta.allure.Step;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Log {
    private static Logger Log = Logger.getLogger(Log.class.getName());

    public static void info (String message) {
        Log.info(message);
    }

    public static void warn (String message) {
        Log.warn(message);
    }

    @Step("ERROR: {message}")
    public static void error (String message) {
        Log.error(message);
    }

    public static void fatal (String message) {
        Log.fatal(message);
    }

    public static void debug (String message) {
        Log.debug(message);
    }

    @Step("{message}")
    public static void step (Level level, String message) {
        log(level, message);
    }

    private static void log (Level level, String message) {
        Log.log(level, message);
    }
}
