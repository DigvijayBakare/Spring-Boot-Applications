package com.multidb.mongodb.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ProductMongo {
    private int id;
    private String name;
    private String description;
    private boolean live;
    private double price;
}
