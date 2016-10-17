package com.qinguangfeng.web.service;

import com.qinguangfeng.dao.entity.Picdetail;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/9.
 */
public interface DetailServ {
    /**
     * 详细信息表 查询全部的方法
     */

    public List<Picdetail> findDetailAll();

    /**
     * 新增的方法
     */
    public boolean addDetail(Picdetail picdetail);

    /**
     * 只查询 新增的图片文本的 url 的方法
     */
    public List<Picdetail> findAddPicdetail();

    /**
     * 为编辑套图详细信息服务。通过单个detailid查询全部 的方法，
     */
    public Picdetail serchDetailAll(int detailid);


    /**
     * 套图详情表编辑的方法，执行编辑
     */
    public int editDetail(Picdetail picdetail);

    /**
     * 只查询 新增的图片文本url的  逻辑增加的方法
     */

    public List<Picdetail> findLogic();


    /**
     * 删除的方法
     */
    public int deleDetail(Integer detailid);

}
