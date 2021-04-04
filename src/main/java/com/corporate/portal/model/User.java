package com.corporate.portal.model;

public class User {
    private int id;
    private String sigmaLogin;
    private String name;
    private String email;

    public User(int id, String sigmaLogin, String name, String email) {
        this.id = id;
        this.sigmaLogin = sigmaLogin;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigmaLogin() {
        return sigmaLogin;
    }

    public void setSigmaLogin(String sigmaLogin) {
        this.sigmaLogin = sigmaLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
