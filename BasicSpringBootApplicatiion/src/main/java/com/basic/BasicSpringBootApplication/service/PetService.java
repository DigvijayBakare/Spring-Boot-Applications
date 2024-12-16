package com.basic.BasicSpringBootApplication.service;

import com.basic.BasicSpringBootApplication.dto.PetDTO;
import com.basic.BasicSpringBootApplication.exceptions.PetNotFoundException;

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;
}
