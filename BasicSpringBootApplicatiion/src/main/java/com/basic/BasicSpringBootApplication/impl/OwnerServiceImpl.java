package com.basic.BasicSpringBootApplication.impl;

import com.basic.BasicSpringBootApplication.dto.OwnerDTO;
import com.basic.BasicSpringBootApplication.service.OwnerService;
import com.basic.BasicSpringBootApplication.exceptions.DuplicateOwnerIdException;
import com.basic.BasicSpringBootApplication.exceptions.OwnerNotFoundException;
import com.basic.BasicSpringBootApplication.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final String duplicateOwner;
    private final String ownerNotFound;

    public OwnerServiceImpl(OwnerRepository ownerRepository, @Value("${duplicate.owner.found}") String duplicateOwner,
                            @Value("${owner.not.found}") String ownerNotFound) {
        this.ownerRepository = ownerRepository;
        this.duplicateOwner = duplicateOwner;
        this.ownerNotFound = ownerNotFound;
    }

    @Override
    public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException {
        if (ownerRepository.findById(ownerDTO.getId()).isPresent()) {
            throw new DuplicateOwnerIdException(String.format(duplicateOwner, ownerDTO.getId()));
        } else {
            ownerRepository.save(ownerDTO);
        }
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
        ownerRepository.updatePetDetails(ownerId, petName);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        ownerRepository.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public List<OwnerDTO> findAllOwners() {
        return ownerRepository.findAll();
    }
}
