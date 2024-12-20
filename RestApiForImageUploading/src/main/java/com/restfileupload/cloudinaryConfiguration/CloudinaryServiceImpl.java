package com.restfileupload.cloudinaryConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryImageService{
    @Autowired
//    private Cloudinary cloudinary;
    @Override
    public Map upload(MultipartFile file) {
        try {
            Map map = this.cloudinary.uploader().upload(Map.of(file.getBytes(), Map.of()));
            return map;
        } catch (IOException e) {
            throw new RuntimeException("Image uploading failed!!");
        }
    }
}
