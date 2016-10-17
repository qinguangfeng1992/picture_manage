package com.qinguangfeng.web.service;

import com.qinguangfeng.dao.entity.Picdetail;
import com.qinguangfeng.dao.entity.Pictype;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/9.
 */
public interface TypeServ {
    /**
     * 详细信息表 查询全部的方法
     */

    public List<Pictype> findTypeAll();
}
