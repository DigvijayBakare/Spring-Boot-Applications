package com.excelpdf.impls;

import com.excelpdf.entities.Product;
import com.excelpdf.helper.ProductExcelHelper;
import com.excelpdf.repositories.ProductRepo;
import com.excelpdf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;


    @Override
    public void saveProduct(MultipartFile file) {
        try {
            List<Product> productList = ProductExcelHelper.convertExcelToList(file.getInputStream());
            this.productRepo.saveAll(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product addSingleProduct(Product product) {
        System.out.println(product);
        return this.productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public void updateProduct(int pId, Product product) {
        Product oldProduct = this.productRepo.findById(pId).orElse(new Product());
        Product updatedProduct = new Product(oldProduct.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), product.getQuantity());
        this.productRepo.save(updatedProduct);
    }

    @Override
    public void deleteProduct(int pId) {
        Product product = this.productRepo.findById(pId).get();
        productRepo.delete(product);
    }
}
