package com.excelpdf.service;

import com.excelpdf.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    public void saveProduct(MultipartFile file);
    public Product addSingleProduct(Product product);
    public List<Product> getAllProducts();
    public void updateProduct(int pId, Product product);
    public void deleteProduct(int pId);
}
