package com.multidb.postgres.repositories;

import com.multidb.postgres.entities.UserPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryPostgres extends JpaRepository<UserPostgres,Integer> {
}
