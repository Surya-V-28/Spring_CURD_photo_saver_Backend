package com.brains.suryass.photoclone.service;


import com.brains.suryass.photoclone.model.Photo;
import com.brains.suryass.photoclone.repository.Photorepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class PhotoService {

    private final Photorepository photorepository;

    public PhotoService(Photorepository photorepository) {
        this.photorepository = photorepository;
    }


    public Iterable <Photo> getAllPhoto() {
        return  photorepository.findAll();
    }


    public Photo get(Integer id) {
        return photorepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
         photorepository.deleteById(id);
    }

    public Photo save(String fileName, byte[] fileBytes, String contentType) {
        Photo photo = new Photo();
        photo.setFilename(fileName);
        photo.setDatas(fileBytes);
        photo.setContentType(contentType);
        photorepository.save(photo);
        return  photo;
    }
}
