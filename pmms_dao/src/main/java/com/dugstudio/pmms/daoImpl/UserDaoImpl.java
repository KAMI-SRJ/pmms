package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.UserDaoCustom;
import com.dugstudio.pmms.dto.UserQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl extends CustomBaseSqlDaoImpl implements UserDaoCustom {

	@SuppressWarnings("unchecked")
	@Override
	public Page<User> queryUsersByPage(UserQueryDto uqt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> map = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder();
		hql.append("select u from User u where 1=1 ");
		if(uqt!=null){
			if(StringUtils.isNotBlank(uqt.getUsername())){
				hql.append(" and u.username like :username ");
				map.put("username", "%"+uqt.getUsername()+"%");
			}
			if(StringUtils.isNotBlank(uqt.getStartDate())){
				hql.append(" and t.createDate  >= :startDate ");
				try {
					map.put("startDate",sdf.parse(uqt.getStartDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(StringUtils.isNotBlank(uqt.getEndDate())){
				hql.append(" and t.createDate  <= :endDate ");
				try {
					map.put("endDate",sdf.parse(uqt.getEndDate()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(StringUtils.isNotBlank(uqt.getClazz())){
				hql.append(" and u.clazz like :clazz");
				map.put("clazz", "%"+uqt.getClazz()+"%");
			}
			if(uqt.getNum()!=0){
				hql.append(" and u.num =:num");
				map.put("num", uqt.getNum());
			}
			if(StringUtils.isNotBlank(uqt.getSno())){
				hql.append(" and u.sno like :sno");
				map.put("sno", "%"+uqt.getSno()+"%");
			}
		}
		if(StringUtils.isNotBlank(uqt.getProfession())){
			hql.append(" and u.profession like :profession");
			map.put("profession", "%"+uqt.getProfession()+"%");
		}
		String type=uqt.getType();
		if(StringUtils.isNotBlank(type)){
			StringBuilder sql = null;
			if("党员".equals(type)){
				hql.append(" and u.role.name='党员'");
			}
			else if("预备党员".equals(type)){
				hql.append(" and u.role.name='预备党员'");
			}
		}
		hql.append(" order by createDate desc ");
		System.out.println("hql:"+hql.toString());

		return this.queryForPageWithParams(hql.toString(), map, uqt.getCurrentPage(), uqt.getPageSize());

	}



}
