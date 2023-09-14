package com.brains.suryass.photoclone.web;


import com.brains.suryass.photoclone.service.PhotoService;
import com.brains.suryass.photoclone.model.Photo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownLoadController {


    private final PhotoService photoService;

    public DownLoadController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("download/{id}")
    private ResponseEntity<byte[]>  downloadImage(@PathVariable Integer id) {

            Photo photo = photoService.get(id);
            if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            byte[] data = photo.getDatas();
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.valueOf(photo.getContentType()));
            ContentDisposition contentDisposition = ContentDisposition.
                builder("attachment").
                filename(photo.getFilename()).
                build();
            header.setContentDisposition(contentDisposition);
            return  new ResponseEntity<byte[]>(data,header, HttpStatus.OK);


    }


}
