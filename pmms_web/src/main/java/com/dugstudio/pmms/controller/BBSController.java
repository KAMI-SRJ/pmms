package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.TopicDto;
import com.dugstudio.pmms.entity.Comment;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Topic;
import com.dugstudio.pmms.entity.User;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.BBSservice;
import com.dugstudio.pmms.service.UserService;
import com.dugstudio.pmms.util.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/BBS")
@Before(AdminInterceptor.class)
public class BBSController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private BBSservice bbsService;
@RequestMapping("/getAllTopic")	
public ModelAndView getAllTopic(HttpServletRequest request,HttpServletResponse response){
	    ModelAndView mav=new ModelAndView();
	try {
		request.setCharacterEncoding("utf-8");
	String title=request.getParameter("title");
	String publisher=request.getParameter("publisher");
	String createDate=request.getParameter("createDate");
	String type=request.getParameter("type");
	String currentPageStr = request.getParameter("currentPage");
	String pageSizeStr = request.getParameter("pageSize");
	int currentPage = 1;
	int pageSize = 5;
	if(StringUtils.isNotBlank(currentPageStr)){
		currentPage = Integer.parseInt(currentPageStr);
	}
	if(StringUtils.isNotBlank(pageSizeStr)){
		pageSize = Integer.parseInt(pageSizeStr);

	}
	TopicDto topic=new TopicDto();
	topic.setcreateTime(createDate);
	topic.setCurrentPage(currentPage);
	topic.setPageSize(pageSize);
	User u=userService.findUserBySno(publisher);
	if(u!=null)
	topic.setPublisher(u);
	topic.setType(type);
	topic.setTitle(title);
	System.out.println(title+publisher);
	Page<Topic> page= bbsService.findAllTopic(topic);
	mav.addObject("page", page);
	mav.addObject("type",type);
	mav.addObject("topic", topic);
	mav.setViewName("manager/index");
	mav.addObject("half_path","../public/bbs");
	mav.addObject("jsp_name","page");
	return mav;
	} catch (Exception e) {
		mav.setViewName("manager/index");
		mav.addObject("half_path","common");
		mav.addObject("jsp_name","fail");
		e.printStackTrace();
		return mav;
	}
}

@RequestMapping("/addOrUpdate")
public ModelAndView addTopic() throws ParseException{
	ModelAndView mav=new ModelAndView();
	mav.setViewName("manager/index");
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		request.setCharacterEncoding("utf-8");
	    Topic topic=null;
	 /*Subject sub=SecurityUtils.getSubject();
	 if(!sub.isAuthenticated()){
		 mav.addObject("msg", "您还未登陆，请登录");
		 return mav;
	 }*/
	String title=request.getParameter("title");
	String type=request.getParameter("type");
	String publisher=request.getParameter("publisher");
	String content=request.getParameter("content");
	String id=request.getParameter("id");
	User u=null;
		if(StringUtils.isNotBlank(id)){
			topic=bbsService.findTopicById(id);
			if (topic==null){
				topic=new Topic();
				topic.setCreateDate(new Date());
			}else{
				topic.setUpdateDate(new Date());
			}
		}else{
			topic=new Topic();
			topic.setCreateDate(new Date());
		}
	if(StringUtils.isNotBlank(publisher)){
		u=userService.findUserByName(publisher);
		if(u!=null){
			System.out.println("publisher:"+u.getUsername());
			u.getTopic().add(topic);
			topic.setPublisher(u);
		}
		else{
			 mav.addObject("msg", "当前用户不存在");
			 return mav;
		}
	}

	if(StringUtils.isNotBlank(type)){
		if ("add".equals(type)||"update".equals(type)){
			mav.addObject("half_path","../public/bbs");
			mav.addObject("jsp_name","add");
			if("update".equals(type)){
				mav.addObject("topic",topic);
			}
			return mav;
		}
	//	topic.setType(Integer.parseInt(type));
	}
    if(StringUtils.isNotBlank(title)){
		topic.setTitle(title);
	}
    if(StringUtils.isNotBlank(content)){
		topic.setContent(content);
	}
	if(topic.getTitle().equals(null)||topic.getPublisher()==null){
		mav.addObject("msg", "主题或话题者不能为空");
		return mav;
	}
	else{
	topic.setCommentsCount(0);
	System.out.println(topic);
	userService.add(u);
	mav.addObject("msg", "保存成功");
	mav.setViewName("redirect:/BBS/getAllTopic.do");
	return mav;
	}
	} catch (UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}
	return mav;
}

@RequestMapping("/getTopicDetail")	
public ModelAndView getTopicDetail(HttpServletRequest request,HttpServletResponse response){
	ModelAndView mav=new ModelAndView();
	mav.setViewName("manager/index");
	String id=request.getParameter("id");
	if(StringUtils.isNotBlank(id)){
		Topic topic=bbsService.findTopicById(id);
		if(topic!=null){
			topic.setCommentsCount(topic.getCommentsCount()+1);
			bbsService.save(topic);
			mav.addObject("topic", topic);
			mav.addObject("half_path","../public/bbs");
			mav.addObject("jsp_name","details");
		}
		else{
			mav.addObject("msg", "找不到");
			mav.addObject("half_path","common");
			mav.addObject("jsp_name","fail");
		}
	}
	return mav;
}

@RequestMapping("/deleteTopic")	
public ModelAndView deleteTopic(){
	ModelAndView mav=new ModelAndView();
	/* Subject sub=SecurityUtils.getSubject();
	 if(!sub.isAuthenticated()){
		 mav.addObject("msg", "您还未登陆，请登录");
		 mav.setViewName("manager/index");
		 return mav;
	 }*/
	String id=request.getParameter("id");
	String userId=request.getParameter("userId");
	if(StringUtils.isNotBlank(id)){
		Topic topic=bbsService.findTopicById(id);
		if(topic!=null){
			System.out.println(topic);
			if(StringUtils.isNotBlank(userId)){
			User u=userService.findUserById(userId);
			if(u!=null){
			u.getTopic().remove(topic);
			userService.add(u);
			bbsService.deleteTopic(topic);
			mav.addObject("topic", topic);
			mav.setViewName("redirect:/BBS/getAllTopic.do");
			return mav;
			}
		}}
	}
			mav.addObject("msg", "找不到");
			mav.setViewName("web/all/fail");
	return mav;
}
@RequestMapping("admin/topic/ajax/audit")
@ResponseBody
public AjaxResult ajaxTopicAudit(HttpServletRequest request){
	
	AjaxResult ajaxResult = new AjaxResult();
	ajaxResult.setSuccess(false);
	String id = request.getParameter("id");
	String auditFlag = request.getParameter("auditFlag");
	try {
		if(StringUtils.isNotBlank(id) ){
		if(StringUtils.isNotBlank(auditFlag) && auditFlag.equals("1")){
			    Topic topic=bbsService.findTopicById(id);
				topic.setIsAudit(1);
				this.bbsService.save(topic);
				ajaxResult.setSuccess(true);
				return ajaxResult;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ajaxResult;
}

	public BBSservice getBbsService() {
		return bbsService;
	}

	public void setBbsService(BBSservice bbsService) {
		this.bbsService = bbsService;
	}

	@RequestMapping("/clickGood")
public ModelAndView clickGood(){
ModelAndView mav=new ModelAndView();
User user=(User)request.getSession().getAttribute("user");
String id=request.getParameter("id");
if (user!=null){
	if (StringUtils.isNotBlank(id)){
		Topic topic =bbsService.findTopicById(id);
		if(topic!=null){
			System.out.println("原来的赞："+topic.getGoods().size()+"hashCode"+topic.hashCode());
			topic.getGoods().add(user);
			System.out.println("点赞数量增加了——"+topic.getGoods().size());
			bbsService.insertTopicGood(topic.getId(),user.getId());
			mav.setViewName("redirect:/BBS/getTopicDetail.do?id="+topic.getId());
			return mav;
		}
	}
}else{
	mav.setViewName("redirect:/front/user/index.do");
	return mav;
}
mav.setViewName("/manager/common/fail");
return mav;
}

@RequestMapping("admin/topic/ajax/Top")
@ResponseBody
public AjaxResult ajaxTopicTop(HttpServletRequest request){
	AjaxResult ajaxResult = new AjaxResult();
	ajaxResult.setSuccess(false);
	String id = request.getParameter("id");
	String auditFlag = request.getParameter("auditFlag");
	try {
		if(StringUtils.isNotBlank(id) ){
		if(StringUtils.isNotBlank(auditFlag) && auditFlag.equals("1")){
			    Topic topic=bbsService.findTopicById(id);
				topic.setIsTop(1);;
				this.bbsService.save(topic);
				ajaxResult.setSuccess(true);
				return ajaxResult;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return ajaxResult;
}
/*
 * 评论控制器
 */
@RequestMapping("/addComment")	
public ModelAndView addComment(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
	try{
		 Subject sub= SecurityUtils.getSubject();
		 if(!sub.isAuthenticated()){
			 mav.addObject("msg", "您还未登陆，请登录");
			 mav.setViewName("web/all/index");
			 return mav;
		 }
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String content=request.getParameter("content");
	String publisher=request.getParameter("publisher");
	Comment comment=null;
	if(StringUtils.isNotBlank(id)){
		if(StringUtils.isBlank(content)){
			mav.addObject("comment", "评论不能为空");
			mav.addObject("id",id);
			mav.setViewName("/front/bbs/add");
			return mav;
		}
		Topic topic=bbsService.findTopicById(id);
		if(topic!=null){
			comment=new Comment();
			comment.setTopic(topic);
			comment.setContent(content);
			comment.setCreateDate(new Date());
			if(StringUtils.isNotBlank(publisher)){
				User u=userService.findUserBySno(publisher);
			if(u!=null){
			comment.setPublisher(u);
			if(u.getTopic().remove(topic)){
				topic.getComments().add(comment);	
			u.getTopic().add(topic);
			userService.add(u);
			}else{
				topic.getComments().add(comment);	
				bbsService.save(topic);
			}
			mav.setViewName("redirect:/BBS/getTopicDetail.do?id="+id);
				}
			}else{
				mav.addObject("msg", "您未登录，请先登录");
				mav.setViewName("redirect:/web_/normal/login.jsp");
			}
		}
	}else	
	mav.addObject("half_path","../public/bbs/comment/addComment");
	}catch(Exception e){
		e.printStackTrace();
	}
return mav;
}
@RequestMapping("/deleteComment")	
public ModelAndView deletetComment(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav=new ModelAndView();
	String id=request.getParameter("id");
	String userId=request.getParameter("userId");
	String topicId=request.getParameter("topicId");
	if(StringUtils.isNotBlank(id)){
		Comment comment=bbsService.findCommentById(id);
		if(comment!=null){
			if(StringUtils.isNotBlank(userId)&&StringUtils.isNotBlank(topicId)){
				User u=userService.findUserById(userId);
			   Topic topic=bbsService.findTopicById(topicId);
			       if(u!=null){
			    	   if(topic!=null){
			    		   if(u==topic.getPublisher()){
			    			   u.getTopic().remove(topic);
			    			   topic.getComments().remove(comment);
			   			       u.getTopic().add(topic);
			   		           userService.add(u);
			   		    	   bbsService.deleteComment(comment);
				    	   }else{
							    topic.getComments().remove(comment);
						    	bbsService.save(topic);
						    	bbsService.deleteComment(comment);
				    	   }
			    	   }
				mav.setViewName("redirect:/BBS/getTopicDetail.do?id="+topicId);
				return mav;
		}
			}
	     }
		}
		mav.setViewName("redirect:/BBS/getAllTopic.do?type=tongguo");
	return mav;
	}
}
