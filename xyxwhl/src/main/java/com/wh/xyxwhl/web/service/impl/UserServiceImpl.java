package com.wh.xyxwhl.web.service.impl;

import com.wh.xyxwhl.web.dao.IBaseDao;
import com.wh.xyxwhl.web.dao.UserMapper;
import com.wh.xyxwhl.web.model.User;
import com.wh.xyxwhl.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 2018/11/7 19:58
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Override
    public IBaseDao<User> getDao() {
        return userMapper;
    }
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
