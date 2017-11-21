package com.example.berka.aktovnostilogovanjegeolokacija.model;

/**
 * Created by berka on 6/26/2017.
 */

public class SendData {

    private String sendAddress;
    private String sendCargo;
    private String sendFellow;
    private User user;

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public String getSendCargo() {
        return sendCargo;
    }

    public void setSendCargo(String sendCargo) {
        this.sendCargo = sendCargo;
    }

    public String getSendFellow() {
        return sendFellow;
    }

    public void setSendFellow(String sendFellow) {
        this.sendFellow = sendFellow;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
