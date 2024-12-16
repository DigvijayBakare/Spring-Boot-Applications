package com.basic.BasicSpringBootApplication.impl;

import com.basic.BasicSpringBootApplication.dto.DomesticPetDTO;
import com.basic.BasicSpringBootApplication.dto.OwnerDTO;
import com.basic.BasicSpringBootApplication.dto.PetDTO;
import com.basic.BasicSpringBootApplication.dto.WildPetDTO;
import com.basic.BasicSpringBootApplication.enumClasses.Gender;
import com.basic.BasicSpringBootApplication.enumClasses.PetType;
import com.basic.BasicSpringBootApplication.repository.PetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {
    private List<PetDTO> petDTOList;

    public PetRepositoryImpl() {
        this.petDTOList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(Gender.M);
        domesticPetDTO.setPetType(PetType.DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("John");
        ownerDTO.setLastName("Doe");
        ownerDTO.setGender(String.valueOf(Gender.M));
        ownerDTO.setCity("Hyderabad");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNo("9009009001");
        ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
        domesticPetDTO.setOwnerDTO(ownerDTO);
        petDTOList.add(domesticPetDTO);
        WildPetDTO wildPetDTO = new WildPetDTO();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(Gender.F);
        wildPetDTO.setPetType(PetType.CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");
        ownerDTO = new OwnerDTO();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Jane");
        ownerDTO.setLastName("Smith");
        ownerDTO.setGender(String.valueOf(Gender.F));
        ownerDTO.setCity("Vishakhapatnam");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNo("9009009002");
        ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
        wildPetDTO.setOwnerDTO(ownerDTO);
        petDTOList.add(wildPetDTO);
    }

    @Override
    public Optional<PetDTO> findById(int petId) {
        return petDTOList.stream().filter(pet -> pet.getId() == petId).findFirst();
    }
}
