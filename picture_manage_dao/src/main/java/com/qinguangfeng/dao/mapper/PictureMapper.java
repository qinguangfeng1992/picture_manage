package com.qinguangfeng.dao.mapper;

import java.util.List;
import java.util.Map;

import com.qinguangfeng.dao.vo.PictureVo;
import org.apache.ibatis.annotations.Param;
import com.qinguangfeng.dao.entity.Picture;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface PictureMapper {

    void insertPicture(Picture picture);

    int deletePictureByPicid(Integer picid);

    int updatePicture(Picture picture);

    int updatePictureDele(Integer picid);

    Page<Picture> searchPictureByParams(@Param("map") Map<String, String> map, Pageable pageable);

    List<Picture> searchPictureByParams(@Param("map") Map<String, String> map);

    //这种two和three的命名方式，后面要改才行！！
    List<Picture> searchPictureByParamsThree(@Param("map") Map<String, String> map);

    Page<Picture> searchPictureByParamsTwo(@Param("map") Map<String, String> map, Pageable pageable);


} 
