package edu.register.peopleregister.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";

    private static final Properties properties = new Properties();

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            try (BufferedInputStream bis =
                         new BufferedInputStream(
                                 new FileInputStream(
                                         "C:\\projects\\people_register\\src\\main\\java\\dao.properties"))) {
                properties.load(bis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return properties.getProperty(name);
    }
}
