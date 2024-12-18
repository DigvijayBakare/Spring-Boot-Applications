package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.helper.FileUploadHelper;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        try {
            // validation
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain the file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG file type are allowed");
            }

            // file upload code
            boolean f = fileUploadHelper.uploadFile(file);
            if (f) {
                // return ResponseEntity.ok("File is successfully uploaded");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!  Try again");
    }
}
