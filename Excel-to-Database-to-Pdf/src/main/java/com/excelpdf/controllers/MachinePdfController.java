package com.excelpdf.controllers;

import com.excelpdf.impls.MachinePdfServiceImpl;
import com.excelpdf.impls.ProductPdfServiceImpl;
import com.excelpdf.repositories.MachineRepo;
import com.excelpdf.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
@RestController
public class MachinePdfController {
    @Autowired
    private MachinePdfServiceImpl pdfService;

    @Autowired
    private MachineRepo machineRepo;

    @GetMapping("/machine-pdf")
    public ResponseEntity<InputStreamResource> generatePdf() {
        ByteArrayInputStream pdf = pdfService.exportPdf();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "inline;file=product_.pdf");

        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
