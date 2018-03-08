package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.RoleQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Role;

public interface RoleDaoCustom {
	public Page<Role> queryRolesByPage(RoleQueryDto rqt);

}
