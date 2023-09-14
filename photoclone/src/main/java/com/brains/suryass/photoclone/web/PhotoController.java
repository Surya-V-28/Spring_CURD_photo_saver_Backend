package com.brains.suryass.photoclone.web;


import com.brains.suryass.photoclone.service.PhotoService;
import com.brains.suryass.photoclone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello World";
    }


    @GetMapping("/photos")
    public  Iterable<Photo> getAllPhoto() {
        return photoService.getAllPhoto();
    }


    @GetMapping("/photos/{id}")
    public  Photo getSinglePhoto(@PathVariable Integer id){
        Photo photo = photoService.get(id);
        if(photo==null)  throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }


    @DeleteMapping("/photos/{id}")
    public void DeleteRecord( @PathVariable Integer id){
         photoService.remove(id);
    }

    @PostMapping("/photos")
    public Photo createRecord(@RequestPart("data") MultipartFile file) throws IOException {

        return  photoService.save(file.getOriginalFilename(), file.getBytes(),file.getContentType());


    }
}
