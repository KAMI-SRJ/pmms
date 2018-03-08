package com.dugstudio.pmms.controller.front;

import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.TopicDto;
import com.dugstudio.pmms.entity.Comment;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Topic;
import com.dugstudio.pmms.entity.User;
import com.dugstudio.pmms.service.BBSservice;
import com.dugstudio.pmms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller("bbs")
@RequestMapping("/front/BBS")
public class BBSController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private BBSservice bbsService;

	@RequestMapping("/getAllTopic")
	public ModelAndView getAllTopic(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		try {
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String publisher = request.getParameter("publisher");
			String createDate = request.getParameter("createDate");
			String type = request.getParameter("type");
			String currentPageStr = request.getParameter("currentPage");
			String pageSizeStr = request.getParameter("pageSize");
			TopicDto topic = new TopicDto();
			if(StringUtils.isNotBlank(currentPageStr)){
				topic.setCurrentPage(Integer.parseInt(currentPageStr));
			}else{
				topic.setCurrentPage(1);
			}
			if (StringUtils.isNotBlank(pageSizeStr)){
				topic.setPageSize(Integer.parseInt(pageSizeStr));
			}else{
				topic.setPageSize(6);
			}
			topic.setcreateTime(createDate);
			User u =null;
			if(StringUtils.isNotBlank(publisher)) {
				u = userService.findUserBySno(publisher);
				if (u != null) {
					topic.setPublisher(u);
				}
			}
			topic.setType(type);
			topic.setTitle(title);
			System.out.println(title + publisher);
			Page<Topic> page =null;
			page=bbsService.findAllTopic(topic);
			mav.addObject("page", page);
			System.out.println("______________page___________________"+page.getList().size());
			if (u!=null){
				mav.setViewName("/front/user/topic");
				return mav;
			}
			topic.setType("hot");
			page=bbsService.findAllTopic(topic);
			mav.addObject("hot_page",page);
			System.out.println("______________hot ___________________"+page.getList().size());
			topic.setType("most");
			page=bbsService.findAllTopic(topic);
			mav.addObject("most_page",page);
			System.out.println("______________most ___________________"+page.getList().size());
			mav.addObject("type", type);
			mav.setViewName("front/bbs/page");
			return mav;
		} catch (Exception e) {
			mav.setViewName("front/common/fail");
			e.printStackTrace();
			return mav;
		}
	}

	@RequestMapping("/addOrUpdate")
	public ModelAndView addTopic() throws ParseException {
		ModelAndView mav = new ModelAndView();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			request.setCharacterEncoding("utf-8");
			Topic topic = null;
			Subject sub = SecurityUtils.getSubject();
			if (!sub.isAuthenticated()) {
				mav.addObject("msg", "您还未登陆，请登录");
				mav.setViewName("redirect:/front/user/index.do");
				return mav;
			}
			String title = request.getParameter("title");
			String type = request.getParameter("type");
			String path=(String)request.getSession().getAttribute("doc_name");
			String publisher = request.getParameter("publisher");
			String content = request.getParameter("content");
			String id = request.getParameter("id");
			User u = null;
			if (StringUtils.isNotBlank(id)) {
				System.out.println("id :" + id);
				topic = bbsService.findTopicById(id);
				if (topic == null) {
					topic = new Topic();
					topic.setCreateDate(new Date());
				} else {
					topic.setUpdateDate(new Date());
				}
			} else {
				System.out.println("id ==null");
				topic = new Topic();
				topic.setCommentsCount(0);
				topic.setCreateDate(new Date());
			}
			if(StringUtils.isNotBlank(path)){
				System.out.println("path:"+path);
				topic.setPath(path);
			}else{
				System.out.println("path ==null");
			}
			if (StringUtils.isNotBlank(publisher)) {
				System.out.println("publisher:" + publisher);
				u = userService.findUserById(publisher);
				if (u != null) {
					System.out.println("publisher:" + u.getUsername());
					u.getTopic().add(topic);
					topic.setPublisher(u);
				} else {
					mav.addObject("msg", "当前用户不存在");
					mav.setViewName("redirect:/front/user/index");
					return mav;
				}
			}
			System.out.println("publisher ==null");
			if (StringUtils.isNotBlank(type)) {
				if ("add".equals(type) || "update".equals(type)) {
					mav.setViewName("/front/bbs/add");
					if ("update".equals(type)) {
						mav.addObject("topic", topic);
					}
					return mav;
				}
				//	topic.setType(Integer.parseInt(type));
			}
			if (StringUtils.isNotBlank(title)) {
				System.out.println("title" + title);
				topic.setTitle(title);
			}
			if (StringUtils.isNotBlank(content)) {
				System.out.println("content" + content);
				topic.setContent(content);
			}
			if (topic.getTitle().equals(null) || topic.getPublisher() == null) {
				mav.addObject("msg", "主题或话题者不能为空");
				mav.setViewName("redirect:/front/user/index");
				return mav;
			} else {

				System.out.println(topic);
				userService.add(u);
				mav.addObject("msg", "保存成功");
				mav.setViewName("redirect:/front/BBS/getAllTopic.do");
				return mav;
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/getTopicDetail")
	public ModelAndView getTopicDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("front/bbs/details");
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Topic topic = bbsService.findTopicById(id);
			if (topic != null) {
				System.out.println("topic " + topic.getTitle() + "浏览量：" + topic.getReaders());
				topic.setReaders(topic.getReaders() + 1);
				System.out.println("topic " + topic.getTitle() + "浏览量：" + topic.getReaders());
				bbsService.save(topic);
				mav.addObject("topic", topic);
			} else {
				mav.addObject("msg", "找不到");
				mav.setViewName("front/common/fail");
			}
		}
		return mav;
	}

	@RequestMapping("/deleteTopic")
	public ModelAndView deleteTopic() {
		ModelAndView mav = new ModelAndView();
	/* Subject sub=SecurityUtils.getSubject();
	 if(!sub.isAuthenticated()){
		 mav.addObject("msg", "您还未登陆，请登录");
		 mav.setViewName("manager/index");
		 return mav;
	 }*/
		String id = request.getParameter("id");
		User user = (User) request.getSession().getAttribute("user");
		if (StringUtils.isNotBlank(id)) {
			Topic topic = bbsService.findTopicById(id);
			if (topic != null) {
				System.out.println(topic);
				if (user != null) {
					user.getTopic().remove(topic);
					userService.add(user);
					System.out.println("666666666666666666666666666666666666");
					bbsService.deleteTopicCommentByTopicOrComment(topic.getId());
					bbsService.deleteAllComment(topic.getComments());
					System.out.println("--------------------------------");
					bbsService.deleteTopicGoodByTopicIdOrUserId(topic.getId());
					System.out.println("88888888888888888888888888888888888888");
					bbsService.deleteTopic(topic);
					System.out.println("=======================================");
					//mav.addObject("topic", topic);
					mav.setViewName("redirect:/front/BBS/getAllTopic.do");
					return mav;
				}
			}
		}
		mav.addObject("msg", "找不到");
		mav.setViewName("/front/common/fail");
		return mav;
	}

	@RequestMapping("/clickGood")
	public ModelAndView clickGood() {
		ModelAndView mav = new ModelAndView();
		try {
			User user = (User) request.getSession().getAttribute("user");
			String id = request.getParameter("id");
			if (user != null) {
				System.out.println("user!=null-----------------");
				if (StringUtils.isNotBlank(id)) {
					System.out.println("topicId   not null");
					Topic topic = bbsService.findTopicById(id);
					if (topic != null) {
						System.out.println("topic not null");
						System.out.println("原来的赞：" + topic.getGoods().size());
						int flag = -1;
						if (!topic.getGoods().contains(user)) {
							topic.getGoods().add(user);
							System.out.println("点赞数量增加了——" + topic.getGoods().size());
							flag = bbsService.insertTopicGood(topic.getId(), user.getId());
						} else {
							topic.getGoods().remove(user);
							flag = bbsService.deleteTopicGoodByTopicIdOrUserId(user.getId());
							System.out.println("点赞数量jiansjao了——" + topic.getGoods().size());
						}
						if (flag > 0) {
							mav.setViewName("redirect:/front/BBS/getTopicDetail.do?id=" + topic.getId());
							return mav;
						}
					}

				}
				mav.setViewName("redirect:/front/user/index.do");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.setViewName("/manager/common/fail");
		return mav;
	}

	/*
     * 评论控制器
     */
	@RequestMapping("/getCommentDetail")
	public ModelAndView getCommentDetail() {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		if (StringUtils.isNotBlank(id)) {
			Comment comment = bbsService.findCommentById(id);
			if (comment != null) {
				mav.addObject("comment", comment);
				mav.setViewName("/front/bbs/comment/details");
				System.out.println("comment not null" + comment);
				return mav;
			}
			System.out.println("comment ==null");
		}
		System.out.println("id null");
		mav.setViewName("/front/common/fail");
		return mav;
	}

	@RequestMapping("/addComment")
	public ModelAndView addComment() {
		ModelAndView mav = new ModelAndView();
		try {
			Subject sub = SecurityUtils.getSubject();
			if (!sub.isAuthenticated()) {
				mav.addObject("msg", "您还未登陆，请登录");
				mav.setViewName("redirect:/front/user/index.do");
				return mav;
			}
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String content = request.getParameter("content");
			User u = (User)request.getSession().getAttribute("user");
			Comment comment = null;

			if (StringUtils.isNotBlank(id)) {
				System.out.println("id" + id);
				Topic topic = bbsService.findTopicById(id);
				if (StringUtils.isBlank(content)) {
					System.out.println("content null");
					mav.addObject("comment", "评论不能为空");
					mav.addObject("topic", topic);
					mav.setViewName("/front/bbs/comment/add");
					return mav;
				}
				System.out.println("content" + content);
				if (topic != null) {
					comment = new Comment();
					comment.setTopic(topic);
					comment.setContent(content);
					comment.setCreateDate(new Date());
						if (u != null) {
							System.out.println("u!=null:" + u);
							comment.setPublisher(u);
							for (Topic t : u.getTopic()) {
								System.out.println("t:" + t.getTitle());
							}
							if (u.getTopic().remove(topic)) {
								topic.getComments().add(comment);
								u.getTopic().add(topic);
								bbsService.save(topic);
							} else {
								System.out.println("u.topic  remove false" + u.getTopic().size());
								topic.getComments().add(comment);
								bbsService.save(topic);
							}
							mav.setViewName("redirect:/front/BBS/getTopicDetail.do?id=" + id);
							return mav;
						} else {
						mav.addObject("msg", "您未登录，请先登录");
						mav.setViewName("redirect:/front/user/index.do");
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/addChildComment")
	public ModelAndView addChildComment() {
		ModelAndView mav = new ModelAndView();
		String parentCommentId = request.getParameter("parentCommentId");
		User user = (User) request.getSession().getAttribute("user");
		String content = request.getParameter("content");
		if (user != null) {
			if (StringUtils.isNotBlank(parentCommentId) && StringUtils.isNotBlank(content)) {
				System.out.println("parecommentid:" + parentCommentId + "content:" + content);
				Comment comment = bbsService.findCommentById(parentCommentId);
				Comment child = new Comment();
				child.setCreateDate(new Date());
				child.setContent(content);
				child.setPublisher(user);
				comment.getSets().add(child);
				bbsService.saveComment(comment);
				System.out.println("save child" + child);
				System.out.println("content" + content);
				System.out.println("parentCommentId" + parentCommentId);
				mav.setViewName("redirect:/front/BBS/getCommentDetail.do?id="+parentCommentId);
				return mav;
			}
			System.out.println("id  content ==null");
			mav.addObject("parentCommentId", parentCommentId);
			mav.setViewName("/front/bbs/comment/addChildComment");
			System.out.println("id  pareComm==null");
			return mav;
		} else {
			System.out.println("当前用户为空");
			mav.setViewName("redirect:/front/user/index.do");

		}
		return mav;

	}

	@RequestMapping("/commentClickGood")
	public ModelAndView commentClickGood() {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String topicId=request.getParameter("topicId");
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			if (StringUtils.isNotBlank(id)) {
				Comment comment = bbsService.findCommentById(id);
				int Flag;
				if(!comment.getGoods().contains(user)) {
					comment.getGoods().add(user);
					Flag=bbsService.saveCommentAndGood(comment.getId(),user.getId());
					System.out.println("点赞了-----------------------------");
				}else{
					System.out.println("已经点赞了");
					comment.getGoods().remove(user);
					Flag=bbsService.deleteCommentAndGood(user.getId());
				}
				if(StringUtils.isNotBlank(topicId)&&Flag>0) {
					mav.setViewName("redirect:/front/BBS/getTopicDetail.do?id="+topicId);
				}else{
					mav.setViewName("redirect:/front/BBS/getCommentDetail.do?id=" +id);
				}
				return mav;
			} else {
				System.out.println("comment par id ==null");
				mav.setViewName("redirect:/front/user/index.do");
				return mav;
			}
		} else {
			System.out.println("user==null");
			mav.setViewName("redirect:/front/user/index.do");
			return mav;
		}

	}

	@RequestMapping("/deleteComment")
	public ModelAndView deletetComment() {
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String userId = ((User) request.getSession().getAttribute("user")).getId();
		String topicId = request.getParameter("topicId");
		if (StringUtils.isNotBlank(id)) {
			Comment comment = bbsService.findCommentById(id);
			if (comment != null) {
				if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(topicId)) {
					User u = userService.findUserById(userId);
					Topic topic = bbsService.findTopicById(topicId);
					if (u != null) {
						if (topic != null) {
							System.out.println("u   topic  !=null");
								topic.getComments().remove(comment);
							System.out.println("--------------------------before--------------");
							bbsService.save(topic);
							System.out.println("--------------------------after--------------");
							bbsService.deleteComment(comment);
							System.out.println("--------------------------delete comment--------------");
						}else{
							System.out.println("topic ==null   ");
							if (comment.getSets()!=null&&comment.getSets().size()>0) {
								System.out.println("comment 还有子评论 " + comment.getSets().size());
								for (Comment c:comment.getSets()) {
									bbsService.deleteComment_comment(c.getId(), comment.getId());
									bbsService.deleteComment(c);
								}
							}
							bbsService.deleteComment(comment);
							System.out.println("----------------------------------------------------删除 comment");
						}
						if(StringUtils.isNotBlank(topicId)) {
							mav.setViewName("redirect:/front/BBS/getTopicDetail.do?id=" + topicId);
						}else{
							System.out.println("--------------------删除了评论  我回到所有话题");
							mav.setViewName("redirect:/front/BBS/getAllTopic.do");
						}
						return mav;
					}
				}
			}
		}
		mav.setViewName("redirect:/front/BBS/getAllTopic.do?type=tongguo");
		return mav;
	}

	@RequestMapping("/deleteChildComment")
	public ModelAndView deleteChildComment() {
		ModelAndView mav = new ModelAndView();
		String id=request.getParameter("id");
		String parentId=request.getParameter("parenId");
		if (StringUtils.isNotBlank(id)&&StringUtils.isNotBlank(parentId)){
			Comment comment=bbsService.findCommentById(id);
			Comment parentComment=bbsService.findCommentById(parentId);
			if (comment!=null&&parentComment!=null)
			bbsService.deleteComment_comment(id,parentId);
			bbsService.deleteComment(comment);
			System.out.println("delete success");
			mav.setViewName("redirect:/front/BBS/getCommentDetail.do?id="+parentId);		}
		return mav;
	}
}
