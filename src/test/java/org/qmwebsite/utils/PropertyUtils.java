package org.qmwebsite.utils;

import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
@UtilityClass
public class PropertyUtils {
    public  Properties propertyLoader(String filePath) {

        try (BufferedReader reader = new BufferedReader((new FileReader(filePath)))) {
            Properties properties = new Properties();
            properties.load(reader);
            return properties;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("properties not found at " + filePath);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file " + filePath);
        }

    }
}
