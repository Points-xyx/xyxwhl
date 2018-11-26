package com.wh.xyxwhl.web.dao;

import com.wh.xyxwhl.web.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    User selectByUserName(String username);
}