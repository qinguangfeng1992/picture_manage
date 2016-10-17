package com.qinguangfeng.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.qinguangfeng.dao.entity.Picdetail;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface PicdetailMapper {

    void insertPicdetail(Picdetail picdetail);

    int deletePicdetailByDetailid(Integer detailid);

    int updatePicdetail(Picdetail picdetail);

    Page<Picdetail> searchPicdetailByParams(@Param("map") Map<String, String> map, Pageable pageable);

    List<Picdetail> searchPicdetailByParams(@Param("map") Map<String, String> map);

    List<Picdetail> findPicdetail(@Param("map") Map<String, String> map);

    List<Picdetail> findPicdetailByLogic();


}
