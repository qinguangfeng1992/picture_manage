package com.qinguangfeng.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.qinguangfeng.dao.entity.Pictype;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface PictypeMapper {

    void insertPictype(Pictype pictype);

    int deletePictypeByTypeid(Integer typeid);

    int updatePictype(Pictype pictype);

    Page<Pictype> searchPictypeByParams(@Param("map") Map<String, String> map, Pageable pageable);

    List<Pictype> searchPictypeByParams(@Param("map") Map<String, String> map);

} 
