package com.qinguangfeng.web.service;

import com.fc.platform.commons.page.Page;
import com.qinguangfeng.dao.entity.Picture;
import com.qinguangfeng.dao.vo.PictureVo;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by dengjicheng on 2016/10/8.
 */
public interface PictureServ {
    /**
     * 查询图片信息表全部内容的方法
     *
     * @return
     */
    public List<Picture> findAll();

    public List<Picture> findAllThree();

    /**
     * 图片信息表新增的方法
     */
    public boolean addPic(Picture picture);

    /**
     * 图片信息表删除的方法
     */
    public int delePic(Integer picid);

    /**
     * 图片信息表编辑的方法，执行编辑
     */
    public int editPic(Picture picture);

    /**
     * 为编辑服务。通过单个picid查询图片信息表全部 的方法，
     */
    public Picture findPicAll(int picid);

    /**
     * 图片信息表的分页的方法
     *
     * @param page
     * @param rowcount
     * @return
     */
    public Page<Picture> findPage(int page, int rowcount);


}
