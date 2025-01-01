package com.multidb.postgres.repositories;

import com.multidb.postgres.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findByName(String name);
}
