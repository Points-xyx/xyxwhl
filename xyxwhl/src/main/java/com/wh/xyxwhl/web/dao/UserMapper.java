package com.wh.xyxwhl.web.dao;

import com.wh.xyxwhl.web.model.User;

public interface UserMapper extends IBaseDao<User>{

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    User selectByUserName(String username);
}