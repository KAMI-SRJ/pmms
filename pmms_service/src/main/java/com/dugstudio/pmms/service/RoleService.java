package com.dugstudio.pmms.service;

import com.dugstudio.pmms.dao.RoleDao;
import com.dugstudio.pmms.dto.RoleQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role findRoleByName(String member) {
        return roleDao.findRoleByName(member);
    }
    public Page<Role> findAllRoles(RoleQueryDto rqt) {
        return roleDao.queryRolesByPage(rqt);
    }
    public  Role add(Role r){
        return roleDao.save(r);
    }
    public Role findRoleById(String id) {
        return roleDao.findOne(id);
    }

    public void delete(Role r) {
        roleDao.delete(r);
    }
}
