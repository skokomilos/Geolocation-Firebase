package com.example.berka.aktovnostilogovanjegeolokacija.server;

import com.example.berka.aktovnostilogovanjegeolokacija.model.SendData;
import com.example.berka.aktovnostilogovanjegeolokacija.model.User;

/**
 * Created by berka on 6/23/2017.
 */

public class ServerRequest {

    private String operation;
    private User user;
    private SendData sendData;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSendData(SendData sendData){
        this.sendData = sendData;
    }
}
