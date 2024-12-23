package com.api.repositories;

import com.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer> {
//    @Query("Update Product set ")
//    public Product updateProduct(int pId, Product product);
}
