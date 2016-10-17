package com.qinguangfeng.web.service.impl;

import com.qinguangfeng.dao.entity.User;
import com.qinguangfeng.dao.mapper.UserMapper;
import com.qinguangfeng.web.service.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dengjicheng on 2016/10/9.
 */
@Service
public class UserImpl implements UserServ {
    @Autowired
    private UserMapper userMapper;

    /**
     * 验证登录的方法
     *
     * @return
     */

    @Override
    public User findUserAll(String username, String password) {

        if (!username.equals("")) {
            Map m = new HashMap();
            m.put("username", username);
            m.put("password", password);

            List<User> list = userMapper.searchUserByParams(m);

            if (list.size() > 0) {
                return list.get(0);
            } else {
                return null;
            }
        }
      /*  这个感觉逻辑有问题*/
        return null;
    }

    /**
     * 注册的方法
     */
    public boolean registerUser(User user) {

        try {
            userMapper.insertUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}



