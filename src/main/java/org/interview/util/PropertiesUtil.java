package org.interview.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties _prop = null;

    public static Properties getProperties() {
        if (_prop == null) {
            getPropValues();
        }
        return _prop;
    }

    private static void getPropValues() {
        try (InputStream inputStream = PropertiesUtil.class
            .getResourceAsStream("/config.properties")) {
            _prop = new Properties();

            if (inputStream != null) {
                _prop.load(inputStream);
            }
            else {
                throw new FileNotFoundException();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}