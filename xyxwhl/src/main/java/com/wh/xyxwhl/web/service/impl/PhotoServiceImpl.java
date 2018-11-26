package com.wh.xyxwhl.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wh.xyxwhl.web.dao.IBaseDao;
import com.wh.xyxwhl.web.dao.PhotoMapper;
import com.wh.xyxwhl.web.model.Photo;
import com.wh.xyxwhl.web.service.IPhotoService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PhotoServiceImpl extends BaseServiceImpl<Photo> implements IPhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public IBaseDao<Photo> getDao() {
        return photoMapper;
    }

    /**
     * 添加图片信息，主键回填
     * @param photo
     */
    @Override
    public void addPhoto(Photo photo) {
        photoMapper.addPhoto(photo);
    }

    /**
     * 物理分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Photo> getPhoto(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        List<Photo> photoList = photoMapper.getPhoto(map);
        return  new PageInfo<>(photoList);
    }
}
