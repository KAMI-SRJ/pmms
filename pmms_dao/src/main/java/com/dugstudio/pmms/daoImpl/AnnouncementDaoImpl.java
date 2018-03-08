package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.AnnouncementDaoCustom;
import com.dugstudio.pmms.dto.AnnouncementDto;
import com.dugstudio.pmms.dto.CurrentAnnouncementInfoDTO;
import com.dugstudio.pmms.entity.Announcement;
import com.dugstudio.pmms.entity.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnouncementDaoImpl extends CustomBaseSqlDaoImpl implements AnnouncementDaoCustom {

	@SuppressWarnings("unchecked")
	@Override
	public Page<Announcement> findAllAnnouncement(AnnouncementDto announcement) {
		StringBuffer hql=new StringBuffer("select a from  Announcement a where 1=1 ");
		Map<String ,Object> map=new HashMap<String, Object>();
		if(StringUtils.isNotBlank(announcement.getTitle())){
		hql.append(" and a.title like :title");
		map.put("title","%"+announcement.getTitle()+"%");
		}
		if(StringUtils.isNotBlank(announcement.getPublisher())){
			hql.append(" and a.publisher like :publisher");
			map.put("publisher","%"+announcement.getPublisher()+"%");
		}
		if(announcement.getIsTop()==1){
			hql.append(" and a.isTop=1");
		}else{
			hql.append(" and a.isTop=0");
		}
		hql.append("  order by createDate desc");
		System.out.println("announence hql:"+hql.toString());
		return this.queryForPageWithParams(hql.toString(), map, announcement.getCurrentPage(), announcement.getPageSize());
	}
	@Override
	public Page<Announcement> findAnnouncements(int currentPage,int pageSize) {
		String hql = new String("select a from  Announcement a  order by createDate desc");
		return this.queryForPageWithParams(hql,null,currentPage,pageSize);
	}

	@Override
	public List<Announcement> queryPreAnnouncementList(CurrentAnnouncementInfoDTO currentAnnouncementInfoDTO) {
		Map<String,Object> map = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder();
		hql.append(" select a from Announcement a where 1=1  ");
		if(StringUtils.isNotBlank(currentAnnouncementInfoDTO.getAnnouncementId())){
			hql.append(" and a.id <> :announcementId ");
			map.put("announcementId", currentAnnouncementInfoDTO.getAnnouncementId());
		}
		if(currentAnnouncementInfoDTO.getAnnouncementDate() != null){
			hql.append(" and a.createDate > :date ");
			map.put("date", currentAnnouncementInfoDTO.getAnnouncementDate());
			hql.append(" order by a.createDate asc ");
		}else if(currentAnnouncementInfoDTO.getOrderNo() != null){
			hql.append(" and a.orderNo > :orderNo ");
			map.put("orderNo", currentAnnouncementInfoDTO.getOrderNo());
			hql.append(" order by a.orderNo asc ");
		}
		System.out.println(hql.toString());
		return this.queryByMapParams(hql.toString(), map);
	}

	@Override
	public List<Announcement> queryNextAnnouncementList(CurrentAnnouncementInfoDTO currentAnnouncementInfoDTO) {
		Map<String,Object> map = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder();
		hql.append(" select a from Announcement a where 1=1  ");
		if(StringUtils.isNotBlank(currentAnnouncementInfoDTO.getAnnouncementId())){
			hql.append(" and a.id <> :announcementId ");
			map.put("announcementId", currentAnnouncementInfoDTO.getAnnouncementId());
		}

		if(currentAnnouncementInfoDTO.getAnnouncementDate() != null){
			hql.append(" and a.createDate < :date ");
			map.put("date", currentAnnouncementInfoDTO.getAnnouncementDate());
			hql.append(" order by a.createDate desc ");
		}else if(currentAnnouncementInfoDTO.getOrderNo() != null){
			hql.append(" and a.orderNo < :orderNo ");
			map.put("orderNo", currentAnnouncementInfoDTO.getOrderNo());
			hql.append(" order by a.orderNo desc ");
		}
		return this.queryByMapParams(hql.toString(), map);
	}
}
