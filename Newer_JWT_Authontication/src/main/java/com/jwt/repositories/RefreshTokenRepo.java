package com.jwt.repositories;

import com.jwt.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken, String> {
    Optional<RefreshToken> findByRefreshId(String token);
}
