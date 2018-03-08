package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.TopicDaoCustom;
import com.dugstudio.pmms.dto.TopicDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Topic;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class TopicDaoImpl extends CustomBaseSqlDaoImpl implements TopicDaoCustom {

	@SuppressWarnings("unchecked")
	@Override
	public Page<Topic> queryTopicPage(TopicDto topic) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql=new StringBuilder("select t from Topic t where 1=1");
         if(topic!=null){
        	 if(StringUtils.isNotBlank(topic.getTitle())){
        		 hql.append(" and t.title like :title ");
        		 map.put("title", "%"+topic.getTitle()+"%");
        	 }
        	 if(topic.getPublisher()!=null){
        		hql.append("and t.publisher like :publisher") ;
        		map.put("publisher", topic.getPublisher());
        	 }
        	 if(StringUtils.isNotBlank(topic.getCreateTime())){
        		 hql.append(" and t.createDate  >= :createDate ");
        		 try {
					map.put("createDate",sdf.parse(topic.getCreateTime()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	 }
        	 if(StringUtils.isNotBlank(topic.getType())){
        		 if(topic.getType().equals("shenhe")){
        			 hql.append(" and t.isAudit=0");
        		 }
        		 if(topic.getType().equals("zhiding")){
        			 hql.append(" and t.isTop=1 and t.isAudit=1");
        		 }
        		 if(topic.getType().equals("tongguo")){
        			 hql.append(" and t.isAudit=1");
        		 }
        	 }
         }
         if(StringUtils.isNotBlank(topic.getType())&&(topic.getType().equals("hot"))){
            
        	// hql.append("  order by t.readers desc, t.createDate desc");

         }else if(StringUtils.isNotBlank(topic.getType())&&(topic.getType().equals("most"))){
				hql.append(" order by t.readers desc");
		 }else {
        	  hql.append(" order by t.createDate desc");
         }
        
         return this.queryForPageWithParams(hql.toString(),map,topic.getCurrentPage(),topic.getPageSize());
	}


}
