package com.basic.BasicSpringBootApplication.repository;

import com.basic.BasicSpringBootApplication.dto.PetDTO;

import java.util.Optional;

public interface PetRepository {
    Optional<PetDTO> findById(int petId);
}
