package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.ResourceDaoCustom;
import com.dugstudio.pmms.dto.ResourceQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Resource;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ResourceDaoImpl extends CustomBaseSqlDaoImpl implements ResourceDaoCustom {

	@SuppressWarnings("unchecked")
	@Override
	public Page<Resource> findResourceByPage(ResourceQueryDto rqt) {
		 Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select r from Resource r where 1=1 ");
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
