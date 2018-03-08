package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Resource;
import org.springframework.data.jpa.repository.Query;

public interface ResourceDao extends CommonDao<Resource, String>,ResourceDaoCustom{

    @Query("select r from Resource r where r.name = ?1")
    public Resource findResourceByName(String re);
}
