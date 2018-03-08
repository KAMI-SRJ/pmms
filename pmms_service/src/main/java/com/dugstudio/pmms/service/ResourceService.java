package com.dugstudio.pmms.service;
import com.dugstudio.pmms.dao.ResourceDao;
import com.dugstudio.pmms.dto.ResourceQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    public Page<Resource> findAllResorces(ResourceQueryDto rqt) {
        return resourceDao.findResourceByPage(rqt);
    }

    public Resource findResourceById(String id) {
        return resourceDao.findOne(id);
    }

    public Resource findResourceByName(String re) {
        // TODO Auto-generated method stub
        return resourceDao.findResourceByName(re);
    }

    public void delete(Resource r) {
        resourceDao.delete(r);
    }
}
