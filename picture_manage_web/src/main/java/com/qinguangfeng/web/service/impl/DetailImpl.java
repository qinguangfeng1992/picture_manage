package com.qinguangfeng.web.service.impl;

import com.qinguangfeng.dao.entity.Picdetail;
import com.qinguangfeng.dao.mapper.PicdetailMapper;

import com.qinguangfeng.web.service.DetailServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dengjicheng on 2016/10/9.
 */
@Service
public class DetailImpl implements DetailServ {
    @Autowired
    private PicdetailMapper picdetailMapper;

    /**
     * 详细信息表 查询全部的方法
     *
     * @return
     */

    @Override
    public List<Picdetail> findDetailAll() {

        return picdetailMapper.searchPicdetailByParams(new HashMap());
    }

    /**
     * 新增的方法,为新增页面服务
     *
     * @return
     */
    @Override
    public boolean addDetail(Picdetail picdetail) {
        try {

            picdetailMapper.insertPicdetail(picdetail);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 去编辑套图的页面
     *
     * @param detailid
     * @return
     */

    @Override
    public Picdetail serchDetailAll(int detailid) {

        Map<String, String> p = new HashMap();
        p.put("detailid", detailid + "");
        List<Picdetail> list = picdetailMapper.searchPicdetailByParams(p);

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
    public int editDetail(Picdetail picdetail) {

        int num = picdetailMapper.updatePicdetail(picdetail);
        return num;
    }


    /**
     * 只查询 新增的图片文本url的方法,为新增页面服务
     */
    @Override
    public List<Picdetail> findAddPicdetail() {
        return picdetailMapper.findPicdetail(new HashMap());
    }


    /**
     * 只查询 新增的图片文本url的  逻辑增加的方法???????
     *
     * 这是为了解决跳转窗口页面的问题。现在用了显示隐藏层，应该就不用了
     */

    @Override
    public List<Picdetail> findLogic() {

        return picdetailMapper.findPicdetailByLogic();
    }

    /**
     * 删除的方法
     */
    @Override
    public int deleDetail(Integer detailid) {
        try {
            picdetailMapper.deletePicdetailByDetailid(detailid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


}