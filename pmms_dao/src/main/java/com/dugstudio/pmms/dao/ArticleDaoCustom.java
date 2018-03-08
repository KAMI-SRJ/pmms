package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.ArticleQueryDto;
import com.dugstudio.pmms.dto.CurrentArticleInfoDTO;
import com.dugstudio.pmms.entity.Article;
import com.dugstudio.pmms.entity.Page;

import java.util.List;
import java.util.Map;

public interface ArticleDaoCustom {
   public Page <Article> findAllArticles(ArticleQueryDto aqt);
   List<Map<String, Object>> queryStatisMapList(ArticleQueryDto articleQueryDTO);

   List<Article> queryNextArticleList(CurrentArticleInfoDTO currentArticleInfoDTO);

   List<Article> queryPreArticleList(CurrentArticleInfoDTO currentArticleInfoDTO);
}
