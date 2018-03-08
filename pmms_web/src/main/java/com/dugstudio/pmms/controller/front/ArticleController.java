package com.dugstudio.pmms.controller.front;

import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.ArticleQueryDto;
import com.dugstudio.pmms.dto.CurrentArticleInfoDTO;
import com.dugstudio.pmms.entity.Article;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

@Controller("article")
@RequestMapping("/front/article")
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/articleAllByPage")
    public ModelAndView findByPage(){
        ModelAndView mav=new ModelAndView("/front/cms/page");
        try{
            request.setCharacterEncoding("utf-8");
            String title=request.getParameter("title");
            String type=request.getParameter("type");
            String publisher =request.getParameter("publisher");
            String currentPage=request.getParameter("currentPage");
            String pageSize=request.getParameter("pageSize");
            ArticleQueryDto aqt=new ArticleQueryDto();
            if (StringUtils.isNotBlank(currentPage)){
                aqt.setCurrentPage(Integer.parseInt(currentPage));
            }else{
                aqt.setCurrentPage(1);
            }
            if (StringUtils.isNotBlank(pageSize)){
                aqt.setPageSize(Integer.parseInt(pageSize));
            }else {
                aqt.setPageSize(10);
            }
            aqt.setTitle(title);
            aqt.setType(type);
            aqt.setPublisher(publisher);
            Page<Article> page=articleService.findAllArticles(aqt);

            if(page!=null) {
                request.getSession().setAttribute("page", page);
                System.out.println("articleAllByPage--------------------");
            }
            return mav;
        }catch (Exception e){
            e.printStackTrace();
            mav.setViewName("/front/common/fail");
            return mav;
        }
    }
    @RequestMapping("/articleDetails")
    public ModelAndView getDetails(){
        ModelAndView mav =new ModelAndView();
        try {
            request.setCharacterEncoding("utf-8");
            String id=request.getParameter("id");
            Article article=articleService.findArticleById(id);
           CurrentArticleInfoDTO cad=new CurrentArticleInfoDTO();
           cad.setArticleDate(article.getCreateDate());
           Article pre=articleService.queryPreArticle(cad);
           Article next=articleService.queryNextArticle(cad);
            if (pre!=null){
                mav.addObject("pre",pre);
            }if (next!=null){
                mav.addObject("next",next);
            }
        if(article!=null){
            article.setViewCount(article.getViewCount()+1);
            articleService.saveOrUpdate(article);
            mav.addObject("article",article);
            mav.setViewName("/front/cms/details");
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mav.addObject("msg", "文章不存在");
        return mav;
    }
}
