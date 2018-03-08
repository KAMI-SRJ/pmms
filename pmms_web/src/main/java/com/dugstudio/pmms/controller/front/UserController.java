package com.dugstudio.pmms.controller.front;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.ArticleQueryDto;
import com.dugstudio.pmms.dto.DocumentQueryDto;
import com.dugstudio.pmms.dto.TopicDto;
import com.dugstudio.pmms.entity.*;
import com.dugstudio.pmms.interceptor.UserInterceptor;
import com.dugstudio.pmms.service.*;
import com.dugstudio.pmms.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("front/userController")
@RequestMapping("front/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private BBSservice bbSservice;
	@Autowired
	private AnnouncementService announcementService;
	@Autowired
	private  DocumentService documentService;
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav=new ModelAndView("/front/index");
		ArticleQueryDto aqt=new ArticleQueryDto();
		aqt.setCurrentPage(1);
		aqt.setPageSize(5);
		TopicDto tqo=new TopicDto();
		tqo.setPageSize(5);
		tqo.setCurrentPage(1);
		DocumentQueryDto dqd=new DocumentQueryDto();
		dqd.setPageSize(5);
		dqd.setCurrentPage(1);
		Page<Article> page=articleService.findAllArticles(aqt);
		aqt.setType("hot");
		aqt.setPageSize(5);
		aqt.setCurrentPage(1);
		Page<Article> hot_page=articleService.findAllArticles(aqt);
		aqt.setType("tuijian");
		Page<Article> tui_page=articleService.findAllArticles(aqt);
		Page<Announcement> announcementPage=announcementService.findAnnouncements(1,5);
		Page<Topic> topicPage=bbSservice.findAllTopic(tqo);
		tqo.setType("hot");
		Page<Topic> page1=bbSservice.findAllTopic(tqo);
		Page<Document> documentPage=documentService.findDocumentByPage(dqd);
		if (hot_page!=null){
			request.getSession().setAttribute("hot_page",hot_page);
			System.out.println("hot cms----------");
		}
		if (tui_page!=null){
			request.getSession().setAttribute("tuijian_page",tui_page);
			System.out.println("tuijian cms----------");
		}
		if (page1!=null){
			request.getSession().setAttribute("hot_topic",page1);
			System.out.println("hot_topic"+page1.getList().size());

		}
		if(page!=null) {
			request.getSession().setAttribute("page", page);
			System.out.println("page----------");
		}
		if (announcementPage!=null){
			request.getSession().setAttribute("announcementpage",announcementPage);
			System.out.println("announcementPage----------");
		}
		if (topicPage!=null){
			request.getSession().setAttribute("topicPage",topicPage);
			System.out.println("topicPage----------");
		}
		if (documentPage!=null){
			request.getSession().setAttribute("documentPage",documentPage);
			System.out.println("documentPage----------");
		}
		return mav;
	}
	@RequestMapping(value={"/userDetails"})
    public ModelAndView getDetails( ){
        ModelAndView mav=new ModelAndView();
                mav.setViewName("/front/user/userDetails");
                return mav;
    }

	@Before(UserInterceptor.class)
    @RequestMapping(value={"/modifyPassword"})
    public ModelAndView modifyPassword( ){
        ModelAndView mav=new ModelAndView();
        String type=request.getParameter("type");
        String prePsw=request.getParameter("prePsw");
        String newPsw=request.getParameter("newPsw");
        User u=(User)request.getSession().getAttribute("user");
        if ("modify".equals(type)){
            mav.setViewName("front/user/modifyPassword");
            return mav;
        }
        if(u!=null){
         if(u.getPassword().equals(MD5Util.generatePassword(prePsw))){
             u.setPassword(MD5Util.generatePassword(newPsw));
             System.out.println("after:"+u);
             userService.add(u);
             mav.addObject("msg","修改成功，请重新登录！！！");
             mav.setViewName("redirect:/login/logout.do");
         }
        }else{
            mav.addObject("msg","请先登录......");
            mav.setViewName("redirect:/login/logout.do");
        }
        return mav;
    }

	@Before(UserInterceptor.class)
	@RequestMapping("/addOrUpdate")
	public ModelAndView  addOrUpdate(){
		ModelAndView mav=new ModelAndView();
		try{
            System.out.println("User_add--update----start---------------------");
            request.setCharacterEncoding("utf-8");
			String sno=request.getParameter("sno");
			String username=request.getParameter("username");
			String gender=request.getParameter("gender");
			String profession=request.getParameter("profession");
			String clazz=request.getParameter("clazz");
			String role=request.getParameter("role");
			String nation =request.getParameter("nation");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String type=request.getParameter("type");
			String id=request.getParameter("id");
			System.out.println("User [username=" + username +  ", sno=" + sno +  ", email="
					+ email + ", phone=" + phone  + ", gender=" + gender
					+ ", profession=" + profession +  ", clazz="
					+ clazz + "role="+role+"]");

			//开始
			if(StringUtils.isNotBlank(type)){
				if ("update".equals(type)&&StringUtils.isNotBlank(id)){
  				User u=userService.findUserById(id);
  				mav.addObject("user",u);
				}
				mav.addObject("half_path", "users");
				mav.addObject("jsp_name", "add");
                System.out.println("进入添加页面");
                mav.setViewName("front/index");
				return mav;
			}
			User u=null;
			Role r=null;
			if(StringUtils.isNotBlank(sno)){
				u=userService.findUserBySno(sno);
                System.out.println("u:"+u);
                if(u==null){
					u=new User();
                    System.out.println("u==null----------start---:"+u);
                    u.setSno(sno);
					if(StringUtils.isNotBlank(username)){
						u.setUsername(username);
					}
					if(StringUtils.isNotBlank(gender)){
						u.setGender(gender);
					}
					if(StringUtils.isNotBlank(clazz)){
						u.setClazz(clazz);
					}
					if(StringUtils.isNotBlank(profession)){
						u.setProfession(profession);
					}
					if(StringUtils.isNotBlank(email)){
						u.setEmail(email);
					}
					if(StringUtils.isNotBlank(phone)){
						u.setPhone(phone);
					}
					if (StringUtils.isNotBlank(nation)){
						u.setNation(nation);
					}
					if (StringUtils.isNotBlank(address)){
						u.setAddrress(address);
					}
					if(StringUtils.isNotBlank(role)){
						r=roleService.findRoleByName(role.trim());
						if(r!=null){
                            System.out.println("r!=null"+r);
							u.setRole(r);
						}
					}
					u.setPassword(MD5Util.generatePassword("1234560"));
                    System.out.println("u==null----------2---:"+u);
                    User user=userService.add(u);
                    if(user!=null){
						System.out.println("user"+user);
						System.out.println("u"+u);
						System.out.println("equals?"+u.equals(user));
						mav.addObject("half_path", "users");
						mav.addObject("jsp_name", "all");
						mav.addObject("msg","添加成功");
						mav.setViewName("redirect:front/user/add.do");

                        System.out.println("u(add)!null----------end---:"+u);
						return mav;
					}

				}
				mav.addObject("msg", "该用户已经存在");
			}else{
				mav.addObject("msg", "未输入学号");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("---------end -----------");
		mav.addObject("half_path", "users");
		mav.addObject("jsp_name", "add");
		mav.setViewName("redirect:front/user/all.do");
		return mav;
	}
}
