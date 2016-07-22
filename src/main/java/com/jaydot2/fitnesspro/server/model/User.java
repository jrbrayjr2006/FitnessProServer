package com.jaydot2.fitnesspro.server.model;

/**
 * Created by jamesbray on 7/21/16.
 */
public class User {

    private String firstname;
    private String lastname;
    private String username;

    public User() {}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
