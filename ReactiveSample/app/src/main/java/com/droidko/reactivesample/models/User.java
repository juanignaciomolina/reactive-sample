package com.droidko.reactivesample.models;

public class User {

    private String email;

    // Default constructor (required by Firebase)
    public User() {}

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
