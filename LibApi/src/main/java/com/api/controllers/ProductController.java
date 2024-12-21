package com.api.controllers;

import com.api.entities.OldProduct;
import com.api.entities.Product;
import com.api.helper.ExcelHelper;
import com.api.impl.ProductServiceImpl;
import com.api.repositories.OldProductRepo;
import com.api.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OldProductRepo oldProductRepo;

    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws InterruptedException {
        Thread.sleep(5000);
        if (ExcelHelper.checkExcelFormat(file)) {
            this.productService.save(file);
            return ResponseEntity.ok(Map.of("message", "File uploaded successfully!! Data is saved in DB!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only!");
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @PutMapping("/update/{pId}")
    public ResponseEntity<?> updateProduct(@PathVariable("pId") int pId, @RequestBody Product p) {
//        Product op = this.productRepo.findById(pId).get();
//        OldProduct oldProduct = new OldProduct(op.getProductId(), op.getProductName(), op.getProductDesc(), op.getProductPrice());
//        oldProductRepo.save(oldProduct);
        this.productService.updateProduct(pId,p);
//        productRepo.save(p);
        return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully!!");
    }
}
