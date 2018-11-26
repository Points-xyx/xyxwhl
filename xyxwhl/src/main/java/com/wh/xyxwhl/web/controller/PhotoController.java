package com.wh.xyxwhl.web.controller;

import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.wh.xyxwhl.web.model.JsonObject;
import com.wh.xyxwhl.web.model.Photo;
import com.wh.xyxwhl.web.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;

@RestController
@RequestMapping("photo")
public class PhotoController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private IPhotoService photoService;


    @Value("${image.server}")
    private String imagePath;

    @RequestMapping(value = "findAllPhoto/{pageIndex}/{pageSize}", method = RequestMethod.GET)
    public JsonObject findAllPhoto(@PathVariable("pageIndex") Integer pageIndex,
                          @PathVariable("pageSize")Integer pageSize){
        System.out.println("pageIndex = " + pageIndex);
        System.out.println("pageSize = " + pageSize);
        try {
            PageInfo<Photo> pageInfo = photoService.getPhoto(pageIndex,pageSize);
            return new JsonObject(pageInfo);
        }catch (Exception e){
            return new JsonObject("error"+e);
        }
    }

    @RequestMapping(value = "addPhoto" , method = RequestMethod.POST)
    public JsonObject addPhoto(Photo photo, MultipartFile imageFile){
        try {
            //文件后缀
            String name = imageFile.getOriginalFilename();
            name = name.substring(name.lastIndexOf(".") + 1);
            /*1.把文件保存起来*/
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(
                    imageFile.getInputStream(),
                    imageFile.getSize(),
                    name,
                    null);
            //图片的组和路径
            String fullPath = storePath.getFullPath();
            /*2.上传到FastFDS*/
            /*添加到数据库*/
            photo.setPhotoAddress(fullPath);
            //添加到数据库 需要先添加到数据库返回id
            photoService.addPhoto(photo);
            photo.setPhotoAddress(imagePath+fullPath);
        } catch (Exception e) {
            return new JsonObject("upload image errorMSG:" + e.getMessage(),"1001");
        }
        return new JsonObject(photo);
    }


    @RequestMapping(value = "deletePhoto" , method = RequestMethod.DELETE)
    public JsonObject delete(Photo photo){
        try{
            //删除数据库中的数据
            photoService.deleteByPrimaryKey(photo.getId().longValue());
            //删除图片文件
            fastFileStorageClient.deleteFile(photo.getPhotoAddress());
            //fastFileStorageClient.deleteFile("组","路径");
        }catch (Exception e){
            return new JsonObject("upload image errorMSG:"+e.getMessage(),"1001");
        }
        return new JsonObject("success");
    }

    @RequestMapping(value = "updatePhoto" , method = RequestMethod.PUT)
    public JsonObject update(Photo photo, MultipartFile imageFile){
        try{
            //删除图片文件
            //fastFileStorageClient.deleteFile(photo.getPhotoAddress());
            //fastFileStorageClient.deleteFile("组","路径");
            //文件后缀
            String name = imageFile.getOriginalFilename();
            name = name.substring(name.lastIndexOf(".") + 1);
            /*1.把文件保存起来*/
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(
                    imageFile.getInputStream(),
                    imageFile.getSize(),
                    name,
                    null);
            //图片的组和路径
            String fullPath = storePath.getFullPath();
            photo.setPhotoAddress(fullPath);

            photoService.updateByPrimaryKeySelective(photo);
        }catch (Exception e){
            return new JsonObject("upload image errorMSG:"+e.getMessage(),"1001");
        }
        return new JsonObject(photo);
    }
}
