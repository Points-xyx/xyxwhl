package com.wh.xyxwhl.web.service;

import com.wh.xyxwhl.web.model.User;

/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 2018/11/7 19:56
 */
public interface UserService {

    User selectByUserName(String username);
}
