package com.basic.BasicSpringBootApplication.impl;

import com.basic.BasicSpringBootApplication.dto.PetDTO;
import com.basic.BasicSpringBootApplication.exceptions.PetNotFoundException;
import com.basic.BasicSpringBootApplication.repository.PetRepository;
import com.basic.BasicSpringBootApplication.service.PetService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final String petNotFound;

    public PetServiceImpl(PetRepository petRepository, @Value("${pet.not.found}") String petNotFound) {
        this.petRepository = petRepository;
        this.petNotFound = petNotFound;
    }

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        return petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException(String.format(petNotFound, petId)));
    }
}
