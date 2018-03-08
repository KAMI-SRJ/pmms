package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.ResourceQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Resource;

public interface ResourceDaoCustom {
    public Page<Resource> findResourceByPage(ResourceQueryDto rqt);
}
