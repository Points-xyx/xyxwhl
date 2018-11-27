package com.wh.xyxwhl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author XieYuanXin
 * @version v1.0.0
 * @since 2018/11/27 11:38
 */
@Controller
public class AdminController {

    @RequestMapping(method = RequestMethod.GET,path = "/adminIndex")
    public String adminIndex(){
        return "admin/index";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/adminWelcome")
    public String adminWelcome(){
        return "admin/welcome";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/adminPicture")
    public String adminPicture(){
        return "admin/picture-list";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/adminPictureAdd")
    public String adminPictureAdd(){
        return "admin/picture-add";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/adminPictureShow")
    public String adminPictureShow(){
        return "admin/picture-show";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/adminFeedback")
    public String adminFeedback(){
        return "admin/feedback-list";
    }


}
