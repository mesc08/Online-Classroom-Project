package com.online.classroom.payload;

public class JwtResponse {
    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public JwtResponse() {
    }

    public JwtResponse(String token, String userName) {
        this.token = token; this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
