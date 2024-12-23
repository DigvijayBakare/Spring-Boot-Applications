package com.jwt.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tokenId;

    private String refreshId;
    private Instant expiry;

    @OneToOne
    private Users users;

    public RefreshToken() {
    }

    public RefreshToken(String refreshId, Instant expiry, Users users) {
        this.refreshId = refreshId;
        this.expiry = expiry;
        this.users = users;
    }

    public String getRefreshId() {
        return refreshId;
    }

    public void setRefreshId(String refreshId) {
        this.refreshId = refreshId;
    }

    public Instant getExpiry() {
        return expiry;
    }

    public void setExpiry(Instant expiry) {
        this.expiry = expiry;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RefreshToken{" +
                "refreshId='" + refreshId + '\'' +
                ", expiry=" + expiry +
                '}';
    }
}
