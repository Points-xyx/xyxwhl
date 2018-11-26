package com.wh.xyxwhl.web.model;

import java.io.Serializable;

public class Photo implements Serializable {
    private Integer id;

    private String photoName;

    private String photoAddress;

    private String description;

    private Integer loveFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName == null ? null : photoName.trim();
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress == null ? null : photoAddress.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getLoveFlag() {
        return loveFlag;
    }

    public void setLoveFlag(Integer loveFlag) {
        this.loveFlag = loveFlag;
    }
}