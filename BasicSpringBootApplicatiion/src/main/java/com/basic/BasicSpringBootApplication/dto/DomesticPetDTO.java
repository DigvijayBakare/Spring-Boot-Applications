package com.basic.BasicSpringBootApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DomesticPetDTO extends PetDTO {
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "DomesticPetDTO {birthDate=" + birthDate + super.toString() + "}";
    }
}
