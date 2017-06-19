package org.interview.model;

import java.time.LocalDateTime;

import org.json.JSONException;
import org.json.JSONObject;

public class Clockin {
    private String _pis;
    private LocalDateTime _dateTime;

    public Clockin(String pis, LocalDateTime dateTime) {
        _pis = pis;
        _dateTime = dateTime;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject clockin = new JSONObject();
        clockin.put("pis", _pis);
        clockin.put("dateTime", _dateTime.toString());
        return clockin;
    }
}
