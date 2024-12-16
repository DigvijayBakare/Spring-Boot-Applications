package com.basic.BasicSpringBootApplication.impl;

import com.basic.BasicSpringBootApplication.dto.DomesticPetDTO;
import com.basic.BasicSpringBootApplication.dto.OwnerDTO;
import com.basic.BasicSpringBootApplication.dto.WildPetDTO;
import com.basic.BasicSpringBootApplication.enumClasses.Gender;
import com.basic.BasicSpringBootApplication.enumClasses.PetType;
import com.basic.BasicSpringBootApplication.repository.OwnerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
    private List<OwnerDTO> ownerDTOList;

    public OwnerRepositoryImpl() {
        this.ownerDTOList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setId(1);
        ownerDTO.setFirstName("John");
        ownerDTO.setLastName("Doe");
        ownerDTO.setGender(String.valueOf(Gender.M));
        ownerDTO.setCity("Hyderabad");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNo("9009009001");
        ownerDTO.setEmailId("john.doe@abhishekvermaa10.com");
        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();
        domesticPetDTO.setId(1);
        domesticPetDTO.setName("Max");
        domesticPetDTO.setGender(Gender.valueOf("M"));
        domesticPetDTO.setPetType(PetType.DOG);
        domesticPetDTO.setBirthDate(LocalDate.of(2018, 7, 26));
        ownerDTO.setPetDTO(domesticPetDTO);
        ownerDTOList.add(ownerDTO);
        ownerDTO = new OwnerDTO();
        ownerDTO.setId(2);
        ownerDTO.setFirstName("Jane");
        ownerDTO.setLastName("Smith");
        ownerDTO.setGender(String.valueOf(Gender.F));
        ownerDTO.setCity("Vishakhapatnam");
        ownerDTO.setState("Andhra Pradesh");
        ownerDTO.setMobileNo("9009009002");
        ownerDTO.setEmailId("jane.smith@abhishekvermaa10.com");
        WildPetDTO wildPetDTO = new WildPetDTO();
        wildPetDTO.setId(2);
        wildPetDTO.setName("Fluffy");
        wildPetDTO.setGender(Gender.F);
        wildPetDTO.setPetType(PetType.CAT);
        wildPetDTO.setBirthPlace("Jim Corbett National Park");
        ownerDTO.setPetDTO(wildPetDTO);
        ownerDTOList.add(ownerDTO);
    }

    @Override
    public void save(OwnerDTO owner) {
        ownerDTOList.add(owner);
    }

    @Override
    public Optional<OwnerDTO> findById(int ownerId) {
        return ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst();
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        ownerDTOList.stream().filter(owner -> owner.getId() == ownerId).findFirst()
                .ifPresent(ownerDTO -> ownerDTO.getPetDTO().setName(petName));
    }

    @Override
    public void deleteById(int ownerId) {
        ownerDTOList.removeIf(owner -> owner.getId() == ownerId);
    }

    @Override
    public List<OwnerDTO> findAll() {
        return ownerDTOList;
    }
}
