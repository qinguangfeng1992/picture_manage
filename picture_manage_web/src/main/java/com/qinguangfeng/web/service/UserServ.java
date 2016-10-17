package com.qinguangfeng.web.service;

import com.qinguangfeng.dao.entity.Pictype;
import com.qinguangfeng.dao.entity.User;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/9.
 */
public interface UserServ {
    /**
     * 详细信息表 查询全部的方法
     */

    public User findUserAll(String username, String password);

    /**
     * 注册的方法
     */
    public boolean registerUser(User user);
}
