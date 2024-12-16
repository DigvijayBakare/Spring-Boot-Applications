package com.basic.BasicSpringBootApplication.serviceImplTest;

import com.basic.BasicSpringBootApplication.dto.DomesticPetDTO;
import com.basic.BasicSpringBootApplication.dto.PetDTO;
import com.basic.BasicSpringBootApplication.exceptions.PetNotFoundException;
import com.basic.BasicSpringBootApplication.impl.PetServiceImpl;
import com.basic.BasicSpringBootApplication.repository.PetRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@TestPropertySource("classpath:messages.properties")
//@SpringBootTest(classes = PetServiceImplTest.class)
@SpringBootTest
@ActiveProfiles("test")
class PetServiceImplTest {
    @InjectMocks
    private PetServiceImpl petServiceImpl;
    @Mock
    private PetRepository petRepository;
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testFindPetWhenFound() throws PetNotFoundException {
        DomesticPetDTO expectedPet = new DomesticPetDTO();
        Optional<PetDTO> optionalPetDTO = Optional.of(expectedPet);
        when(petRepository.findById(1)).thenReturn(optionalPetDTO);
        PetDTO actualPetDTO = petServiceImpl.findPet(1);
        assertEquals(expectedPet, actualPetDTO);
        verify(petRepository, times(1)).findById(1);
    }

    @Test
    void testFindPetWhenNotFound() {
        String expectedMessage = "Pet not found with petId 2";
        Optional<PetDTO> optionalPetDTO = Optional.empty();
        when(petRepository.findById(2)).thenReturn(optionalPetDTO);
        PetNotFoundException actualException = assertThrows(PetNotFoundException.class,
                () -> petServiceImpl.findPet(2));
        assertEquals(expectedMessage, actualException.getMessage());
        verify(petRepository, times(1)).findById(2);
    }
}
