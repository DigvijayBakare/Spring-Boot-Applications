package com.api.impl;

import com.api.entities.OldProduct;
import com.api.entities.OldProductInfo;
import com.api.entities.Product;
import com.api.helper.ExcelHelper;
import com.api.repositories.OldProductInfoRepo;
import com.api.repositories.OldProductRepo;
import com.api.repositories.ProductRepo;
import com.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OldProductRepo oldProductRepo;

    @Autowired
    private OldProductInfoRepo oldProductInfoRepo;

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
    public void updateProduct(int pId, Product updateProduct) {
        // fetch the existing existingProduct
        Product existingProduct = productRepo.findById(pId).orElseThrow(() -> new RuntimeException("Product not found!!"));

        // compare fields and create records for change
        if (!existingProduct.getProductName().equals(updateProduct.getProductName())) {
            createAuditRecord(pId, "productName", existingProduct.getProductName(), updateProduct.getProductName());
            existingProduct.setProductName(updateProduct.getProductName());
        }

        if (!existingProduct.getProductDesc().equals(updateProduct.getProductDesc())) {
            createAuditRecord(pId, "productDesc", existingProduct.getProductDesc(), updateProduct.getProductDesc());
            existingProduct.setProductDesc(updateProduct.getProductDesc());
        }

        if (existingProduct.getProductPrice() != updateProduct.getProductPrice()) {
            createAuditRecord(pId, "productPrice", String.valueOf(existingProduct.getProductPrice()), String.valueOf(updateProduct.getProductPrice()));
            existingProduct.setProductPrice(updateProduct.getProductPrice());
        }
    }

    private void createAuditRecord(int productId, String fieldName, String oldValue, String newValue) {
        OldProduct product = new OldProduct();
        product.setProductId(productId);
        product.setFieldName(fieldName);
        product.setOldValue(oldValue);
        product.setNewValue(newValue);
        product.setUpdatedAt(new Date());
        oldProductRepo.save(product);
    }

    /*@Override
    public void updateProduct(int pId, Product updatedProduct) {
        // fetch the existing existingProduct
//        Product product = productRepo.findById(pId).orElseThrow(() -> new RuntimeException("Product not found!!"));
//        OldProductInfo op = new OldProductInfo(product.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), product.getProductId(),new Date());
//        oldProductInfoRepo.save(op);

        OldProductInfo existingProduct = oldProductInfoRepo.findById(pId).orElseThrow(() -> new RuntimeException("Product not found!!"));

        System.out.println(existingProduct);
        // save the old existingProduct info
//        OldProduct oldProduct = new OldProduct(existingProduct.getProductId(), existingProduct.getProductName(),
//                existingProduct.getProductDesc(), existingProduct.getProductPrice(), updatedProduct.getProductId(),
//                updatedProduct.getProductName(), updatedProduct.getProductDesc(), updatedProduct.getProductPrice());

        OldProductInfo oldProduct = new OldProductInfo();
        if (updatedProduct.getProductId() == existingProduct.getoProductId()) {
            oldProduct.setoProductId(existingProduct.getoProductId());
            oldProduct.setProductId(existingProduct.getoProductId());
//            if (oldProduct.getoProductName()==null&&oldProduct.getoProductDesc()==null&&oldProduct.getoProductPrice()==0){
//                oldProduct.setoProductName(product.getProductName());
//                oldProduct.setoProductDesc(product.getProductDesc());
//                oldProduct.setoProductPrice(product.getProductPrice());
//            }
            if (!updatedProduct.getProductName().equals(existingProduct.getoProductName())) {
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
            oldProduct.setUpdatedAt(new Date());
            oldProductInfoRepo.save(oldProduct);
        }
//        return existingProduct;
    }*/
}
