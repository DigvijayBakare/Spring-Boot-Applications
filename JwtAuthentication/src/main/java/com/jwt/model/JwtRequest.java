package com.jwt.model;

import lombok.*;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@ToString
public class JwtRequest {
    private String userName;
    private String password;
}
