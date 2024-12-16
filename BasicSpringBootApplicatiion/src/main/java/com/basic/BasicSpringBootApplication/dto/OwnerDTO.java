package com.basic.BasicSpringBootApplication.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class OwnerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String city;
    private String state;
    private String mobileNo;
    private String emailId;
    private PetDTO petDTO;

    @Override
    public String toString() {
        if (Objects.nonNull(petDTO)) {
            return "OwnerDTO {" + "id=" + id + ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' + ", gender='" + gender + '\'' +
                    ", city='" + city + '\'' + ", state='" + state + '\'' + ", mobileNo='" +
                    mobileNo + '\'' + ", emailId='" + emailId + '\'' + ", petDTO=" + petDTO + '}';
        } else {
            return "OwnerDTO {" + "id=" + id + ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' + ", gender='" + gender + '\'' +
                    ", city='" + city + '\'' + ", state='" + state + '\'' + ", mobileNo='" +
                    mobileNo + '\'' + ", emailId='" + emailId + '\'' + '}';
        }
    }
}
