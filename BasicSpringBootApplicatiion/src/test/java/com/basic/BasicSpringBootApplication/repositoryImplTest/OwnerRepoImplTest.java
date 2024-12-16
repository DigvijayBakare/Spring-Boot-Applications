package com.basic.BasicSpringBootApplication.repositoryImplTest;

import com.basic.BasicSpringBootApplication.dto.OwnerDTO;
import com.basic.BasicSpringBootApplication.impl.OwnerRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OwnerRepoImplTest {
    @Autowired
    private OwnerRepositoryImpl ownerRepositoryImpl;

    private List<OwnerDTO> ownerDTOList;

    @BeforeEach
    public void setUp() {
        ownerDTOList = (List<OwnerDTO>) ReflectionTestUtils.getField(ownerRepositoryImpl, "ownerDTOList");
        ownerDTOList.clear();
    }

    @Test
    void testSave() {
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setId(1);
        ownerRepositoryImpl.save(expectedOwnerDTO);
        List<OwnerDTO> actualOwnerDTOList = (List<OwnerDTO>) ReflectionTestUtils.getField(ownerRepositoryImpl, "ownerDTOList");
        assertEquals(expectedOwnerDTO, actualOwnerDTOList.get(0));
    }

    @Test
    void testFindByWhenFound() {
        OwnerDTO expectedOwnerDTO = new OwnerDTO();
        expectedOwnerDTO.setId(1);
        ownerDTOList.add(expectedOwnerDTO);
        Optional<OwnerDTO> actualOptionalOwnerDTO = ownerRepositoryImpl.findById(1);
        assertEquals(expectedOwnerDTO, actualOptionalOwnerDTO.get());
    }

    @Test
    void testFindByIdWhenNotFound() {
        Optional<OwnerDTO> expectedOptionalOwnerDTO = Optional.empty();
        Optional<OwnerDTO> actualOptionalOwnerDTO = ownerRepositoryImpl.findById(1);
        assertEquals(expectedOptionalOwnerDTO, actualOptionalOwnerDTO);
    }

    @Test
    void testDeleteByIdWhenFound() {
        ownerRepositoryImpl.deleteById(1);
        Optional<OwnerDTO> expectedOptionalOwnerDTO = Optional.empty();
        Optional<OwnerDTO> actualOptionalOwnerDTO = ownerRepositoryImpl.findById(1);
        assertEquals(expectedOptionalOwnerDTO, actualOptionalOwnerDTO);
    }

    @Test
    void testFindAll() {
        List<OwnerDTO> actualOwnerDTOList = ownerRepositoryImpl.findAll();
        assertNotNull(actualOwnerDTOList);
    }
}