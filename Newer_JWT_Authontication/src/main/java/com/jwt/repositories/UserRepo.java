package com.jwt.repositories;

import com.jwt.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, String> {
    public Optional<Users> findByEmail(String email);
}
