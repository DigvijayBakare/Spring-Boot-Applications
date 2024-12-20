package com.restfileupload.cloudinaryConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/cloudinary/upload")
public class CloudinaryImageUploadController {
    @Autowired
    private CloudinaryImageService cloudinaryImageService;
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) {
        Map data = this.cloudinaryImageService.upload(file);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
