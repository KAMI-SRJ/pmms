package com.dugstudio.pmms.service;

import com.dugstudio.pmms.dao.ArticleDao;
import com.dugstudio.pmms.dto.ArticleQueryDto;
import com.dugstudio.pmms.dto.CurrentArticleInfoDTO;
import com.dugstudio.pmms.entity.Article;
import com.dugstudio.pmms.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    public Page<Article> findAllArticles(ArticleQueryDto aqt) {
       return  articleDao.findAllArticles(aqt);
    }

    public Article findArticleById(String id) {
        return articleDao.findArticleById(id);
    }
    public boolean saveOrUpdate(Article article){
        if (articleDao.save(article)!=null){
            System.out.println("ArticleService  save success");
            return true;
        }
        else{
            return false;
        }
    }

    public void delete(Article article) {
        articleDao.delete(article.getId());
    }
    public Article queryNextArticle(CurrentArticleInfoDTO currentArticleInfoDTO){
        Article article = null;
        List<Article> articleList = this.articleDao.queryNextArticleList(currentArticleInfoDTO);
        if(articleList != null && articleList.size() > 0){
            article = articleList.get(0);
        }
        return article;
    }

    public Article queryPreArticle(CurrentArticleInfoDTO currentArticleInfoDTO){
        Article article = null;
        List<Article> articleList = this.articleDao.queryPreArticleList(currentArticleInfoDTO);
        if(articleList != null && articleList.size() > 0){
            article = articleList.get(0);
        }
        return article;
    }
}
