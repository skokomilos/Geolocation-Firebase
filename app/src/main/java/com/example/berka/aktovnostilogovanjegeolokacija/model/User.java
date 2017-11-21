package com.example.berka.aktovnostilogovanjegeolokacija.model;

import java.util.List;

/**
 * Created by berka on 6/23/2017.
 */

public class User {

    private String name;
    private String email;
    private String password;
    private String unique_id;
    private List<SendData> sendDatas;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public List<SendData> getSendDatas() {
        return sendDatas;
    }

    public void setSendDatas(List<SendData> sendDatas) {
        this.sendDatas = sendDatas;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
