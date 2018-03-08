package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.ArticleQueryDto;
import com.dugstudio.pmms.dto.CurrentArticleInfoDTO;
import com.dugstudio.pmms.entity.Article;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.User;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.ArticleService;
import com.dugstudio.pmms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
@RequestMapping("/article")
@Before(AdminInterceptor.class)
public class ArticleController extends BaseController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @RequestMapping("/index")
    public ModelAndView index(){

        ModelAndView mav=new ModelAndView("manager/index");
        mav.addObject("half_path","../public/cms");
        mav.addObject("jsp_name","page");
        return mav;
    }

    @RequestMapping("/articleAllByPage")
    public ModelAndView findByPage(){

        ModelAndView mav=new ModelAndView("manager/index");
        try{
            request.setCharacterEncoding("utf-8");
            String title=request.getParameter("title");
            String type=request.getParameter("type");
            String publisher =request.getParameter("publisher");
            String currentPage=request.getParameter("currentPage");
            String pageSize=request.getParameter("pageSize");
            String query_type =request.getParameter("query_type");
            String keyword =request.getParameter("keyword");
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
            if (StringUtils.isNotBlank(query_type)&&StringUtils.isNotBlank(keyword)){
                if ("主题".equals(query_type)){
                    aqt.setTitle(keyword);
                }
                if ("上传人".equals(query_type)){
                    aqt.setPublisher(keyword);
                }
                if("类型".equals(query_type)){
                    aqt.setType(keyword);
                }
            }
            Page<Article> page=articleService.findAllArticles(aqt);
            if(page!=null) {
                mav.addObject("page", page);
                mav.addObject("half_path", "../public/cms");
                mav.addObject("jsp_name", "page");
                return mav;
            }
        }catch (Exception e){
            e.printStackTrace();
            mav.addObject("half_path","common");
            mav.addObject("jsp_name","fail");
            return mav;
        }
        mav.addObject("half_path","common");
        mav.addObject("jsp_name","fail");
        return mav;
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
            mav.setViewName("manager/index");
            mav.addObject("half_path","../public/cms");
            mav.addObject("jsp_name","details");
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mav.addObject("msg", "文章不存在");
        return mav;
    }
    @RequestMapping("/addOrUpdate")
    public ModelAndView addOrUpdate(){
        ModelAndView mav = new ModelAndView("manager/index");
        try {
            request.setCharacterEncoding("utf-8");
            String id=request.getParameter("id");
            String title = request.getParameter("title");
            String type = request.getParameter("type");
            String content=request.getParameter("content");
            String publisher = request.getParameter("publisher");
            User user=(User)request.getSession().getAttribute("user");
            String update =request.getParameter("update");
            String coverImageUrl=(String)request.getSession().getAttribute("doc_name");
            System.out.println("coverImageUrl:"+coverImageUrl);
            System.out.println(":title:"+title);
            System.out.println("--------------------saveOrUpdate-------------------");
            Article article=null;
            if (user==null){
                //回到登录
                mav.setViewName("redirect:/front/user/index.do");
                return mav;
            }
            if("add".equals(type)){
                System.out.println("type==add");
                    mav.setViewName("/public/cms/add");
                System.out.println("cms add --------------------------");
                    return mav;
            }
            if (StringUtils.isNotBlank(id)){
                article=  articleService.findArticleById(id);
                System.out.println("id:-----"+id);
                if (StringUtils.isNotBlank(update)){
                    mav.addObject("article",article);
                    mav.setViewName("public/cms/add");
                    return mav;
                }
                article.setUpdateDate(new Date());
            }else{
                article=new Article();
                article.setCreateDate(new Date());
                article.setIsTop(0);
                article.setIsAudit(0);
                article.setViewCount(0);
                article.setType(0);
            }
                if (StringUtils.isNotBlank(publisher)){
                   article.setPublisher(publisher);
                }
                if (StringUtils.isNotBlank(title)){
                    article.setTitle(title);
                }
                if (StringUtils.isNotBlank(content)){
                    article.setContent(content);
                }
                if(StringUtils.isNotBlank(coverImageUrl)){
                    article.setCoverImageUrl(coverImageUrl);
                }
                System.out.println("article add:"+title+content+publisher+title);
                if(articleService.saveOrUpdate(article)){
                    System.out.println("article save---------------------------");
                    mav.setViewName("redirect:/article/articleAllByPage.do");
                    return mav;
                }

            mav.setViewName("/public/cms/add");
        }catch(Exception e){
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(){
        String id=request.getParameter("id");
        ModelAndView mav=new ModelAndView("manager/index");
       Article article= articleService.findArticleById(id);
       if(article!=null){
           articleService.delete(article);
           System.out.println("article delete:");
           mav.setViewName("redirect:/article/articleAllByPage.do");
           return mav;
       }
        mav.addObject("half_path","cms");
        mav.addObject("jsp_name","page");
        return mav;
    }
    @RequestMapping("/audit")
    public ModelAndView ajaxArticleAudit(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        try {
            int isAudit = 0;
            String[] ids = request.getParameterValues("id");
            String auditFlag = request.getParameter("auditFlag");
            if(StringUtils.isNotBlank(auditFlag) && auditFlag.equals("1")){
                isAudit = 1;
            }
            if(ids != null && ids.length > 0){
                for(String id:ids){
                    Article article = this.articleService.findArticleById(id);
                    article.setIsAudit(isAudit);
                    this.articleService.saveOrUpdate(article);
                }
                mav.setViewName("redirect:/article/articleAllByPage.do");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("half_path","common");
            mav.addObject("jsp_name","fail");
            return mav;
        }

        return mav;
    }

    /**
     * 文章置顶
     * @return
     */
    @RequestMapping("/top")
    public ModelAndView ajaxArticleTop(){
        ModelAndView mav = new ModelAndView("manager/index");
        try {
            int isTop = 0;
            String[] ids = request.getParameterValues("id");
            String topFlag = request.getParameter("topFlag");
            if(StringUtils.isNotBlank(topFlag) && topFlag.equals("1")){
                isTop = 1;
            }
            if(ids != null && ids.length > 0){
                for(String id:ids){
                    Article article = this.articleService.findArticleById(id);
                    article.setIsTop(isTop);
                    this.articleService.saveOrUpdate(article);
                }
            }
            mav.setViewName("redirect:/article/articleAllByPage.do");
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("half_path","common");
            mav.addObject("jsp_name","fail");
            return mav;
        }
        return mav;
    }



}
