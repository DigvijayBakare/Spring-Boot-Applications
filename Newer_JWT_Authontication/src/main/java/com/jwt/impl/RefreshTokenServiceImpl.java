package com.jwt.impl;

import com.jwt.entities.RefreshToken;
import com.jwt.entities.Users;
import com.jwt.repositories.RefreshTokenRepo;
import com.jwt.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl {
    @Autowired
    private RefreshTokenRepo refreshTokenRepo;

    @Autowired
    private UserRepo userRepo;

    private long refreshTokenValidity = 2 * 60 * 1000;

    public RefreshToken createRefreshToken(String userName) {
        Users users = userRepo.findByEmail(userName).get();
        RefreshToken refreshToken = users.getRefreshToken();
        if (refreshToken == null) {
            refreshToken = new RefreshToken(UUID.randomUUID().toString()
                    , Instant.now().plusMillis(refreshTokenValidity),
                    users);
        } else {
            refreshToken.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
        }

        users.setRefreshToken(refreshToken);

        // saving the token to the database
        this.refreshTokenRepo.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken validateRefreshToken(String refreshToken) {
        RefreshToken validToken = refreshTokenRepo.findByRefreshId(refreshToken)
                .orElseThrow(() -> new RuntimeException("Given token does not exists!!"));

        if (validToken.getExpiry().compareTo(Instant.now()) < 0) {
            Users users = validToken.getUsers();
            users.setRefreshToken(null);
            this.refreshTokenRepo.delete(validToken);
            throw new RuntimeException("Refresh token expired!!");
        }
        return validToken;
    }
}
