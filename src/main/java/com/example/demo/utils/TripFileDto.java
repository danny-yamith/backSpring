package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class TripFileDto implements Serializable {
    private MultipartFile file;

    public TripFileDto() {
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
