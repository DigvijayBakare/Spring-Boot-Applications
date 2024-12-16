package com.basic.BasicSpringBootApplication.dto;

import com.basic.BasicSpringBootApplication.enumClasses.Gender;
import com.basic.BasicSpringBootApplication.enumClasses.PetType;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter@Setter
public class PetDTO {
    private int id;
    private String name;
    private Gender gender;
    private PetType petType;
    private OwnerDTO ownerDTO;

    @Override
    public String toString() {
        if (Objects.nonNull(ownerDTO)) {
            return "PetDTO {" + "id=" + id + ", name='" + name + '\'' +
                    ", gender=" + gender + ", petType=" + petType + ", ownerDTO=" + ownerDTO + '}';
        } else {
            return "PetDTO {" + "id=" + id + ", name='" + name + '\'' +
                    ", gender=" + gender + ", petType=" + petType + '}';
        }
    }
}
