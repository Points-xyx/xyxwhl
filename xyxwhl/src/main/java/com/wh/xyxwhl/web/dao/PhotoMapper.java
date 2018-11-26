package com.wh.xyxwhl.web.dao;

import com.wh.xyxwhl.web.model.Photo;
import org.mybatis.spring.annotation.MapperScan;

import java.util.HashMap;
import java.util.List;

@MapperScan
public interface PhotoMapper  extends IBaseDao<Photo> {

    void addPhoto(Photo photo);

    List<Photo> getPhoto(HashMap<String, Object> map);
}