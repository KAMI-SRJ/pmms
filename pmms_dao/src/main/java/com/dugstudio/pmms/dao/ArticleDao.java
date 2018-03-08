package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Article;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends CommonDao<Article,String> ,ArticleDaoCustom{
    @Query("select a from Article  a where a.id =?1")
   public  Article findArticleById(String id);
}
