package com.basic.BasicSpringBootApplication.repository;

import com.basic.BasicSpringBootApplication.dto.OwnerDTO;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    void save(OwnerDTO owner);

    Optional<OwnerDTO> findById(int ownerId);

    void updatePetDetails(int ownerId, String petName);

    void deleteById(int ownerId);

    List<OwnerDTO> findAll();
}
