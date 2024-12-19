package com.bootjpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class UserJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String status;
}
