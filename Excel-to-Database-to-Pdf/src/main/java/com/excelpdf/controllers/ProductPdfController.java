package com.excelpdf.controllers;

import com.excelpdf.impls.ProductPdfServiceImpl;
import com.excelpdf.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ProductPdfController {
    @Autowired
    private ProductPdfServiceImpl pdfService;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/product-pdf")
    public ResponseEntity<InputStreamResource> generatePdf() {
        ByteArrayInputStream pdf = pdfService.exportPdf();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDate = dateFormat.format(new Date());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline;file=product_" + currentDate + ".pdf");

        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
