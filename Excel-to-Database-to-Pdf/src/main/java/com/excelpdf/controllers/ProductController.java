package com.excelpdf.controllers;

import com.excelpdf.entities.Product;
import com.excelpdf.helper.ProductExcelHelper;
import com.excelpdf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/excel/upload")
    public String uploadExcel(Model model) {
        model.addAttribute("excel","Uploading an Excel file");
        return "excelUpload";
    }

    @PostMapping("/process/upload")
    public ResponseEntity<?> upload(@RequestParam("productData") MultipartFile file) throws InterruptedException {
        Thread.sleep(5000);
        if (ProductExcelHelper.checkExcelFormat(file)) {
            this.productService.saveProduct(file);
            return ResponseEntity.ok(Map.of("message", "File uploaded successfully!! Data is saved in DB!"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only!");
    }

    @GetMapping("/add-product")
    public String addProduct(Model m) {
        m.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/process-product")
    public String processAddProject(@ModelAttribute Product product) {
        productService.addSingleProduct(product);
        return "redirect:/all-products";
    }

    @GetMapping("/all-products")
//    public List<Product> getAllProducts() {
    public String getAllProducts(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products",products);
        return "productslist";
    }

    @PutMapping("/update/{pId}")
    public ResponseEntity<?> updateProduct(@PathVariable("pId") int pId, @RequestBody Product p) {
        this.productService.updateProduct(pId, p);
        return ResponseEntity.status(HttpStatus.OK).body("Product updated successfully!!");
    }

    @DeleteMapping("/delete/{pId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("pId") int pId) {
        this.productService.deleteProduct(pId);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully!!");
    }
}
