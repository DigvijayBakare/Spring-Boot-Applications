package com.multidb.postgres.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Postgres_Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@Builder
@ToString
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private boolean live;
    private double price;
}
