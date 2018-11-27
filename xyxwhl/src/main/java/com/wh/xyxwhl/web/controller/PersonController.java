package com.wh.xyxwhl.web.controller;

import com.wh.xyxwhl.web.model.JsonObject;
import com.wh.xyxwhl.web.model.User;
import com.wh.xyxwhl.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 2018/11/6 9:33
 */
@Controller
public class PersonController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET,path = "/login")
    public String login(){
        return "login";
    }


    @RequestMapping(method = RequestMethod.POST,path = "/person/submitLogin")
    @ResponseBody
    public JsonObject submitLogin(String username , String password , HttpServletRequest request){
        if(username != null && password != null){
            User user = userService.selectByUserName(username);
            if(user == null){
                return new JsonObject("用户名不存在!","1001");
            }else{
                String pwd = user.getPassword();
                if(password.equals(pwd)){
                    request.getSession().setAttribute("user",user);
                    return new JsonObject("登录成功!");
                }else{
                    return new JsonObject("用户名密码错误!","1001");
                }
            }
        }
        return new JsonObject("用户名密码错误!","1001");
    }
}
