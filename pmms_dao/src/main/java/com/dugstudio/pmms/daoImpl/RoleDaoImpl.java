package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.RoleDaoCustom;
import com.dugstudio.pmms.dto.RoleQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Role;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RoleDaoImpl extends CustomBaseSqlDaoImpl implements RoleDaoCustom {

	@SuppressWarnings("unchecked")
	public Page<Role> queryRolesByPage(RoleQueryDto rqt){
		System.out.println("RoleDaoImpl:");
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select r from Role r where 1=1 ");
		if(rqt!=null){
			if(StringUtils.isNotBlank(rqt.getName())){
				hql.append(" and name like :name ");
				map.put("name", "%"+rqt.getName()+"%");
			}
		}
		hql.append(" order by createDate desc ");
		System.out.println("hql:"+hql.toString());
		return this.queryForPageWithParams(hql.toString(), map, rqt.getCurrentPage(), rqt.getPageSize());
		
	}


	

}
