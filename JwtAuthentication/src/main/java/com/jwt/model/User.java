package com.jwt.model;

import jakarta.persistence.*;
import lombok.*;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@ToString
@Entity
@Table(name = "userClass")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newGenerator")
    @SequenceGenerator(name = "newGenerator", allocationSize = 1, sequenceName = "newSGenerator")
    private Long id;
    private String userName;
    private String password;
    private String email;
    private String role;
    private boolean enabled;
}
