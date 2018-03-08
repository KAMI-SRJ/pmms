package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.UserQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.User;

public interface UserDaoCustom {
	public Page<User> queryUsersByPage(UserQueryDto uqt);

}
