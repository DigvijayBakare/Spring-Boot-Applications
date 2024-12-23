package com.jwt.models;

public class RefreshTokenRequest {
    private String refreshTokenRequest;

    public RefreshTokenRequest(String refreshTokenRequest) {
        this.refreshTokenRequest = refreshTokenRequest;
    }

    public RefreshTokenRequest() {
    }

    public String getRefreshTokenRequest() {
        return refreshTokenRequest;
    }

    public void setRefreshTokenRequest(String refreshTokenRequest) {
        this.refreshTokenRequest = refreshTokenRequest;
    }

    @Override
    public String toString() {
        return "RefreshTokenRequest {" +
                "refreshTokenRequest='" + refreshTokenRequest + '\'' +
                '}';
    }
}
