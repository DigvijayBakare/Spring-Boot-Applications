package com.api.services;

import com.api.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public void save(MultipartFile file);
    public List<Product> getAllProducts();
    public void updateProduct(int pId, Product updateProduct);
}
