package com.basic.BasicSpringBootApplication.service;

import com.basic.BasicSpringBootApplication.dto.OwnerDTO;
import com.basic.BasicSpringBootApplication.exceptions.DuplicateOwnerIdException;
import com.basic.BasicSpringBootApplication.exceptions.OwnerNotFoundException;

import java.util.List;


public interface OwnerService {
    void saveOwner(OwnerDTO owner) throws DuplicateOwnerIdException;

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwners();
}
