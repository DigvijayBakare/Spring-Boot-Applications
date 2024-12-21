package com.api.impl;

import com.api.entities.OldProduct;
import com.api.entities.Product;
import com.api.helper.ExcelHelper;
import com.api.repositories.OldProductRepo;
import com.api.repositories.ProductRepo;
import com.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OldProductRepo oldProductRepo;

    @Override
    public void save(MultipartFile file) {
        try {
            List<Product> productList = ExcelHelper.convertExcelToList(file.getInputStream());
            this.productRepo.saveAll(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public void updateProduct(int pId, Product updatedProduct) {
        // fetch the existing existingProduct
//        Product product = productRepo.findById(pId).orElseThrow(() -> new RuntimeException("Product not found!!"));
//        OldProduct op = new OldProduct(product.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), product.getProductId());
//        oldProductRepo.save(op);

        OldProduct existingProduct = oldProductRepo.findById(pId).orElseThrow(() -> new RuntimeException("Product not found!!"));

        // save the old existingProduct info
//        OldProduct oldProduct = new OldProduct(existingProduct.getProductId(), existingProduct.getProductName(),
//                existingProduct.getProductDesc(), existingProduct.getProductPrice(), updatedProduct.getProductId(),
//                updatedProduct.getProductName(), updatedProduct.getProductDesc(), updatedProduct.getProductPrice());

        OldProduct oldProduct = new OldProduct();
        if (updatedProduct.getProductId() == existingProduct.getProductId()) {
            oldProduct.setoProductId(existingProduct.getProductId());
            oldProduct.setProductId(existingProduct.getProductId());
//            if (oldProduct.getoProductName()==null&&oldProduct.getoProductDesc()==null&&oldProduct.getoProductPrice()==0){
//                oldProduct.setoProductName(product.getProductName());
//                oldProduct.setoProductDesc(product.getProductDesc());
//                oldProduct.setoProductPrice(product.getProductPrice());
//            }
            if (!updatedProduct.getProductName().equals(existingProduct.getProductName())) {
                oldProduct.setoProductName(existingProduct.getProductName());
                oldProduct.setProductName(updatedProduct.getProductName());
            } else {
                oldProduct.setoProductName(existingProduct.getProductName());
                oldProduct.setProductName(updatedProduct.getProductName());
            }
            if (!updatedProduct.getProductDesc().equals(existingProduct.getProductDesc())) {
                oldProduct.setoProductDesc(existingProduct.getProductDesc());
                oldProduct.setProductDesc(updatedProduct.getProductDesc());
            } else {
                oldProduct.setoProductDesc(existingProduct.getProductDesc());
                oldProduct.setProductDesc(updatedProduct.getProductDesc());
            }
            if (updatedProduct.getProductPrice() != (existingProduct.getProductPrice())) {
                oldProduct.setoProductPrice(existingProduct.getProductPrice());
                oldProduct.setProductPrice(updatedProduct.getProductPrice());
            } else {
                oldProduct.setoProductPrice(existingProduct.getProductPrice());
                oldProduct.setProductPrice(updatedProduct.getProductPrice());
            }
            oldProductRepo.save(oldProduct);
        }
//        return existingProduct;
    }
}
