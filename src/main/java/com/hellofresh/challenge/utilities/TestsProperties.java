package com.hellofresh.challenge.utilities;

import org.testng.internal.PropertyUtils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class used to extract properties from properties file. If any extra parameters are going to be passed
 * to the tests via command line, then this is the utility to use.
 */
public class TestsProperties {

    private static final String TEST_PROPERTIES_FILENAME = "tests.properties";

    public static Properties loadPropertiesFile() {
        Properties properties = new Properties();

        try {
            InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream(TEST_PROPERTIES_FILENAME);
            properties.load(inputStream);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to load properties.", e);
        }
        return properties;
    }
}
