package com.wh.xyxwhl.web.dao;

import com.wh.xyxwhl.web.model.Photo;

import java.util.HashMap;
import java.util.List;

public interface PhotoMapper extends IBaseDao<Photo>{
    List<Photo> getPhoto(HashMap<String,Object> map);

    void addPhoto(Photo photo);
}