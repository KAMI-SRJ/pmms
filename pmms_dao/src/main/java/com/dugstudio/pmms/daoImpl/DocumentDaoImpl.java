package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.DocumentDaoCustom;
import com.dugstudio.pmms.dto.DocumentQueryDto;
import com.dugstudio.pmms.entity.Document;
import com.dugstudio.pmms.entity.Page;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DocumentDaoImpl extends CustomBaseSqlDaoImpl implements DocumentDaoCustom  {

    @Override
    public Page<Document> findDocumentByPage(DocumentQueryDto documentQueryDto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer hql=new StringBuffer("select d from Document d where 1=1 ");
        Map<String,Object> map=new HashMap<String,Object>();
        if(StringUtils.isNotBlank(documentQueryDto.getName())){
            hql.append(" and d.name like :name");
            map.put("name","%"+documentQueryDto.getName()+"%");
        }
        if (StringUtils.isNotBlank(documentQueryDto.getPublisher())){
            System.out.println(documentQueryDto.getPublisher()+"----------------------------");
            hql.append(" and d.publisher.username like :publisher");
            map.put("publisher","%"+documentQueryDto.getPublisher()+"%");
        }
        if(StringUtils.isNotBlank(documentQueryDto.getTeacher())){
            hql.append(" and d.teacher like :teacher");
            map.put("teacher","%"+documentQueryDto.getTeacher()+"%");
        }
        if (StringUtils.isNotBlank(documentQueryDto.getClazz())){
            hql.append(" and d.publisher.clazz like :clazz ");
            map.put("clazz","%"+documentQueryDto.getClazz()+"%");
        }
        if ((StringUtils.isNotBlank(documentQueryDto.getProfession()))){
            hql.append(" and d.publisher.profession like :profession");
            map.put("profession","%"+documentQueryDto.getProfession()+"%");
        }
        if (StringUtils.isNotBlank(documentQueryDto.getCreateDate())){
            hql.append(" and d.createDate >= :createDate");
            System.out.println("create :"+hql.toString());
            try {
                map.put("createDate", sdf.parse(documentQueryDto.getCreateDate()));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(documentQueryDto.getEndDate())){
            hql.append(" and d.createDate <= :endDate");
            System.out.println("endate :"+hql.toString());
            try {
                map.put("endDate", sdf.parse(documentQueryDto.getEndDate()));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(documentQueryDto.getType())){
            hql.append(" and d.type = :type");
            System.out.println(documentQueryDto.getType());
            if("心得体会".equals(documentQueryDto.getType())){
                map.put("type",0);
            }else if("思想汇报".equals(documentQueryDto.getType())){
                map.put("type",1);
            }else if("学习资料".equals(documentQueryDto.getType())){
                map.put("type",2);
            }else if("4".equals(documentQueryDto.getType())){
                map.put("type",4);
            }else{
                map.put("type",5);//查询文件类型不对
            }
        }
        hql.append(" order by d.createDate desc");
        return this.queryForPageWithParams(hql.toString(),map,documentQueryDto.getCurrentPage(),documentQueryDto.getPageSize());
    }
}
