package com.validate.entities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class LoginData {
    @NotBlank(message = "User name can not be empty!!")
    @Size(min = 3, max = 12, message = "User name must be between 3 to 12 characters!!")
    private String userName;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email!!")
    private String email;
    @AssertTrue(message = "Must agree terms and conditions!!")
    private boolean agreed;
}
