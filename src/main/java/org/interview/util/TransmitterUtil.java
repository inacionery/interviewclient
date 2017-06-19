package org.interview.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.json.JSONObject;

public class TransmitterUtil {

    public synchronized static void sendEmployee(JSONObject clockin)
        throws IOException {

        URL url = new URL("http://" + properties.getProperty("server") + ":"
            + properties.getProperty("port") + "/api/clockin/create");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        OutputStream out = connection.getOutputStream();

        out.write(clockin.toString().getBytes("UTF-8"));
        out.flush();

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            System.out.println(
                "Failed : HTTP error code : " + connection.getResponseCode());
            System.out.println(clockin.toString());
        }

        connection.disconnect();
    }

    protected final static Properties properties = PropertiesUtil
        .getProperties();
}