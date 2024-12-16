package com.basic.BasicSpringBootApplication.repositoryImplTest;

import com.basic.BasicSpringBootApplication.dto.DomesticPetDTO;
import com.basic.BasicSpringBootApplication.dto.PetDTO;
import com.basic.BasicSpringBootApplication.impl.PetRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = PetRepositoryImpl.class)
class PetRepoImplTest {
    @Autowired
    private PetRepositoryImpl petRepositoryImpl;

    private List<PetDTO> petDTOList;

    @BeforeEach
    public void setUp() {
        petDTOList = (List<PetDTO>) ReflectionTestUtils.getField(petRepositoryImpl, "petDTOList");
        petDTOList.clear();
    }

    @Test
    void testFindPetWhenFound() {
        DomesticPetDTO expectedPet = new DomesticPetDTO();
        expectedPet.setId(1);
        petDTOList.add(expectedPet);
        Optional<PetDTO> actualOptionalPetDTO = petRepositoryImpl.findById(1);
        assertEquals(expectedPet, actualOptionalPetDTO.get());
    }

    @Test
    void testFindPetWhenNotFound() {
        Optional<PetDTO> expectedOptionalPetDTO = Optional.empty();
        Optional<PetDTO> actualOptionalPetDTO = petRepositoryImpl.findById(2);
        assertEquals(expectedOptionalPetDTO, actualOptionalPetDTO);
    }
}
