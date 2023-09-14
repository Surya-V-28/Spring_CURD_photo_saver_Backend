package com.brains.suryass.photoclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("PHOTOS")
public class Photo {



     @Id
    private Integer id;
    @NotEmpty
    private String filename;

    private  String contentType;


    @JsonIgnore
    private byte[] datas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getDatas() {
        return datas;
    }


    public void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Photo(Integer id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Photo() {
    }
}
