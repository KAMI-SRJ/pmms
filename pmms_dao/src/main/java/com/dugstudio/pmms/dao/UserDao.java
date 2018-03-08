package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends CommonDao<User, String>,UserDaoCustom {
	@Query("select u from User u where u.sno=?1")
    public User findUserBySno(String sno);
    @Query("select u from User u where u.username like ?1")
    User findUserByUsername(String publisher);
}
