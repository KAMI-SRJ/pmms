package com.dugstudio.pmms.daoImpl;

import com.dugstudio.pmms.core.CustomBaseSqlDaoImpl;
import com.dugstudio.pmms.dao.ArticleDaoCustom;
import com.dugstudio.pmms.dto.ArticleQueryDto;
import com.dugstudio.pmms.dto.CurrentArticleInfoDTO;
import com.dugstudio.pmms.entity.Article;
import com.dugstudio.pmms.entity.Page;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticleDaoImpl extends CustomBaseSqlDaoImpl implements ArticleDaoCustom {
    @Override
    public Page<Article> findAllArticles(ArticleQueryDto aqt) {
        StringBuffer hql=new StringBuffer("select a from Article a where 1=1 ");
        System.out.println(";;;impl:"+aqt);
        Map<String,Object> map=new HashMap<String,Object>();
        if (StringUtils.isNotBlank(aqt.getTitle())){
            hql.append(" and a.title like :title ");
            map.put("title","%"+aqt.getTitle()+"%");
        }
        if (StringUtils.isNotBlank(aqt.getPublisher())){
            hql.append(" and a.publisher like :publisher");
            map.put("publisher","%"+aqt.getPublisher()+"%");
        }
        if (StringUtils.isNotBlank(aqt.getType())){
            if("top".equals(aqt.getType())){
                hql.append(" and a.isTop =1");
            }
            if ("audit".equals(aqt.getType())){
                hql.append(" and a.isAudit =1" );
            }
        }
        if (StringUtils.isNotBlank(aqt.getType())&&"hot".equals(aqt.getType())){
            hql.append(" order by a.viewCount desc ");
        }else{
            hql.append(" order by createDate desc ");
        }

        return this.queryForPageWithParams(hql.toString(),map,aqt.getCurrentPage(),aqt.getPageSize());
    }

    public List<Map<String, Object>> queryStatisMapList(ArticleQueryDto articleQueryDTO){
        String sql = " select count(1) as totalCount,(select count(1) from cms_article where is_top=1 and delete_flag = '0') as zhidingCount,(select count(1) from cms_article where is_audit=1 and delete_flag = '0') as shenheCount,(select count(1) from cms_article where delete_flag='1') as deleteCount from cms_article a  ";
        return this.querySqlObjects(sql);
    }

    public List<Article> queryNextArticleList(CurrentArticleInfoDTO currentArticleInfoDTO){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append(" select a from Article a where 1=1  ");
        if(StringUtils.isNotBlank(currentArticleInfoDTO.getArticleId())){
            hql.append(" and a.id <> :articleId ");
            map.put("articleId", currentArticleInfoDTO.getArticleId());
        }

        if(currentArticleInfoDTO.getArticleDate() != null){
            hql.append(" and a.createDate < :date ");
            map.put("date", currentArticleInfoDTO.getArticleDate());
            hql.append(" order by a.createDate desc ");
        }else if(currentArticleInfoDTO.getOrderNo() != null){
            hql.append(" and a.orderNo < :orderNo ");
            map.put("orderNo", currentArticleInfoDTO.getOrderNo());
            hql.append(" order by a.orderNo desc ");
        }
        return this.queryByMapParams(hql.toString(), map);
    }

    public List<Article> queryPreArticleList(CurrentArticleInfoDTO currentArticleInfoDTO){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append(" select a from Article a where 1=1  ");
        if(StringUtils.isNotBlank(currentArticleInfoDTO.getArticleId())){
            hql.append(" and a.id <> :articleId ");
            map.put("articleId", currentArticleInfoDTO.getArticleId());
        }
        if(currentArticleInfoDTO.getArticleDate() != null){
            hql.append(" and a.createDate > :date ");
            map.put("date", currentArticleInfoDTO.getArticleDate());
            hql.append(" order by a.createDate asc ");
        }else if(currentArticleInfoDTO.getOrderNo() != null){
            hql.append(" and a.orderNo > :orderNo ");
            map.put("orderNo", currentArticleInfoDTO.getOrderNo());
            hql.append(" order by a.orderNo asc ");
        }
        System.out.println(hql.toString());
        return this.queryByMapParams(hql.toString(), map);
    }

}
