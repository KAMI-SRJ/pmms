package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Role;
import org.springframework.data.jpa.repository.Query;

public interface RoleDao extends CommonDao<Role, String>,RoleDaoCustom{
    @Query("select r from Role r where r.name= ?1")
	public Role findRoleByName(String role);

}
