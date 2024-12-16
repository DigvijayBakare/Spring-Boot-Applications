package com.basic.BasicSpringBootApplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WildPetDTO extends PetDTO {
    private String birthPlace;

    @Override
    public String toString() {
        return "WildPetDTO {birthPlace=" + birthPlace + super.toString() + "}";
    }
}
