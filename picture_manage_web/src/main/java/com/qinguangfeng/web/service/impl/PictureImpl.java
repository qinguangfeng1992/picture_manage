package com.qinguangfeng.web.service.impl;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.qinguangfeng.dao.entity.Picture;
import com.qinguangfeng.dao.mapper.PictureMapper;

import com.qinguangfeng.web.service.PictureServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dengjicheng on 2016/10/8.
 */
@Service
public class PictureImpl implements PictureServ {
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 查询图片信息表全部内容的方法
     *
     * @return
     */
    @Override
    public List<Picture> findAll() {
        return pictureMapper.searchPictureByParams(new HashMap());
    }

    @Override
    public List<Picture> findAllThree() {
        return pictureMapper.searchPictureByParamsThree(new HashMap());
    }

    /**
     * 图片信息表删除的方法，用逻辑删除
     */
    @Override
    public int delePic(Integer picid) {

        try {
          /*  pictureMapper.deletePictureByPicid(picid);*/
            pictureMapper.updatePictureDele(picid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 图片信息表新增的方法
     */
    @Override
    public boolean addPic(Picture picture) {
        try {

            pictureMapper.insertPicture(picture);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 为编辑服务。通过单个picid查询图片信息表全部 的方法，
     */
    @Override
    public Picture findPicAll(int picid) {

        Map<String, String> p = new HashMap();
        p.put("picid", picid + "");
        List<Picture> list = pictureMapper.searchPictureByParams(p);
/**
 * 如果根据ID查到一条数据，就从第一个元素开始取
 */
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }

    }

    /**
     * 图片信息表编辑的方法，执行编辑
     */
    @Override
    public int editPic(Picture picture) {

        int num = pictureMapper.updatePicture(picture);
        return num;
    }

    /**
     * 分页的方法
     */
    @Override
    public Page<Picture> findPage(int page, int rowcount) {
        //平台项目内置 的分页的类
        PageRequest pg = new PageRequest(page, rowcount);
        //null代表查询全部
        //这里用的也是查询全部  的方法，只不过是第二个Pagel类查询全部，xml里面加了一个只查询逻辑删除的数据
/*        Page<Picture> data = pictureMapper.searchPictureByParams(null, pg);*/
        Page<Picture> data = pictureMapper.searchPictureByParamsTwo(null, pg);

        return data;

    }


}
