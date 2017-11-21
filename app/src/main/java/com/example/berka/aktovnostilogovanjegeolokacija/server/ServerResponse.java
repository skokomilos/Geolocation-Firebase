package com.example.berka.aktovnostilogovanjegeolokacija.server;

import com.example.berka.aktovnostilogovanjegeolokacija.model.User;

/**
 * Created by berka on 6/23/2017.
 */

public class ServerResponse {

    private String result;
    private String message;
    private User user;

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
