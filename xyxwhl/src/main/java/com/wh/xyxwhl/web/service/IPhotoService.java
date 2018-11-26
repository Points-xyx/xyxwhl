package com.wh.xyxwhl.web.service;

import com.github.pagehelper.PageInfo;
import com.wh.xyxwhl.web.model.Photo;

public interface IPhotoService extends IBaseService<Photo>{
    void addPhoto(Photo photo);

    PageInfo<Photo> getPhoto(Integer pageIndex, Integer pageSize);
}
