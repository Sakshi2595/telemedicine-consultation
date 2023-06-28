package com.stackroute.telemedicineconsultation.authentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserModel {

    // create fields for user class
    @Id
    private String emailId;
    private String password;
    private String name;

    public UserModel(String emailId, String password, String name) {
        this.emailId = emailId;
        this.password = password;
        this.name = name;
    }

    public UserModel() {
    }

    public UserModel(String emailId, String password) {
        emailId=this.emailId;
        password=this.password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}
