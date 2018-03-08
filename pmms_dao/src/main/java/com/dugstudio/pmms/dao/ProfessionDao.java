package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Profession;
import org.springframework.data.jpa.repository.Query;

public interface ProfessionDao extends CommonDao<Profession,String> {
	@Query("select p from Profession p where p.p_name = ?1")
	public Profession findProfessionByName(String name);
}
