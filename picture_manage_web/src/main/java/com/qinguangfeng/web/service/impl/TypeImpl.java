package com.qinguangfeng.web.service.impl;


import com.qinguangfeng.dao.entity.Pictype;

import com.qinguangfeng.dao.mapper.PictypeMapper;

import com.qinguangfeng.web.service.TypeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dengjicheng on 2016/10/9.
 */
@Service
public class TypeImpl implements TypeServ {
    @Autowired
    private PictypeMapper pictypeMapper;

    /**
     * 详细信息表 查询全部的方法
     *
     * @return
     */

    @Override
    public List<Pictype> findTypeAll() {

        return pictypeMapper.searchPictypeByParams(new HashMap());
    }


}