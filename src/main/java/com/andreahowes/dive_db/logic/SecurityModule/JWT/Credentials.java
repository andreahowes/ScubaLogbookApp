package com.andreahowes.dive_db.logic.SecurityModule.JWT;

public class Credentials {
    private String user;
    private String Password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
