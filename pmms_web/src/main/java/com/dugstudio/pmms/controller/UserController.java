package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.UserQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Role;
import com.dugstudio.pmms.entity.User;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.RoleService;
import com.dugstudio.pmms.service.UserService;
import com.dugstudio.pmms.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/user")
@Before(AdminInterceptor.class)
public class UserController extends BaseController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@RequestMapping(value={"/all"})
	public ModelAndView findAllUsers(){
		ModelAndView mav=new ModelAndView();
		try{
		request.setCharacterEncoding("UTF-8");
		String sno=request.getParameter("sno");
		String username=request.getParameter("username");
		String clazz=request.getParameter("clazz");
		String createDate=request.getParameter("createDate");
		String type=request.getParameter("type");
		String currentPage=request.getParameter("currentPage");
		String pageSize=request.getParameter("pageSize");
		String keyword=request.getParameter("keyword");
		UserQueryDto uqt =new UserQueryDto();
		uqt.setClazz(clazz);
		uqt.setCreateDate(createDate);
		uqt.setUsername(username);
		uqt.setSno(sno);
		if(StringUtils.isNotBlank(type)&&StringUtils.isNotBlank(keyword)){
			System.out.println(type+keyword);
			if("sno".equals(type)){
				uqt.setSno(keyword);
			}
			if("username".equals(type)){
				uqt.setUsername(keyword);
			}
			if("clazz".equals(type)){
				uqt.setClazz(keyword);
			}
			if("profession".equals(type)){
				uqt.setProfession(keyword);
			}
		}
		System.out.println(type);
            if("profession".equals(type)){
				uqt.setProfession(keyword);
			}
		uqt.setType(type);
		
		if(currentPage!=null){
			uqt.setCurrentPage(Integer.parseInt(currentPage));
		}else{
			uqt.setCurrentPage(1);
		}
		
		if(StringUtils.isNotBlank(pageSize)){
			uqt.setPageSize(Integer.parseInt(pageSize));
		}else{
			uqt.setPageSize(10);
		}
		
		Page<User> page=userService.findAllUsers(uqt);
		if(page!=null){
		mav.addObject("page", page);
		mav.addObject("half_path", "users");
		mav.addObject("jsp_name", "page");
		mav.setViewName("manager/index");
		}else{
		mav.setViewName("manager/common/fail");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}

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
			String identify=request.getParameter("identify");
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
                mav.setViewName("manager/index");
				return mav;
			}
			User u=null;
			Role r=null;
			if(StringUtils.isNotBlank(sno)){
				u=userService.findUserBySno(sno);
                System.out.println("u:"+u);
                if(u==null){
                	u=new User();
                	u.setStatus(1);
                    u.setSno(sno);
                    u.setIsAdmin(0);
                    u.setCreateDate(new Date());
                    System.out.println("u==null----------start---:"+u);
                    u.setPassword(MD5Util.generatePassword("1234560"));
                    System.out.println("u==null----------2---:"+u);
				}else{
                    u.setUpdateDate(new Date());
                	mav.addObject("msg", "该用户已经存在");
				}
			}else{
				mav.addObject("half_path", "users");
				mav.addObject("jsp_name", "add");
				mav.addObject("msg", "未输入学号");
				return mav;
			}
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
				if(StringUtils.isNotBlank(identify)){
					u.setIdentify(identify);
				}
				if (StringUtils.isNotBlank(address)){
					u.setAddrress(address);
				}
				if(StringUtils.isNotBlank(role)){
					r=roleService.findRoleByName(role.trim());
					if(r!=null){
						u.setRole(r);
					}
				}
				User user=userService.add(u);
				if(user!=null){
					System.out.println("user"+user);
					System.out.println("u"+u);
					System.out.println("equals?"+u.equals(user));
                    mav.addObject("half_path", "users");
                    mav.addObject("jsp_name", "page");
					mav.addObject("msg","添加成功");
					mav.setViewName("redirect:/user/all.do");
					System.out.println("u(add)!null----------end---:"+u);
					return mav;
				}

		}catch(Exception e){
			e.printStackTrace();
		}
        mav.addObject("half_path", "users");
        mav.addObject("jsp_name", "page");
		System.out.println("---------end -----------");
		mav.setViewName("redirect:/user/all.do");
		return mav;
	}
	@RequestMapping(value={"/userDetails"})
	public ModelAndView getDetails( ){
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		if (StringUtils.isNotBlank(id)){
			System.out.println("userDetails"+id);
			User user=userService.findUserById(id);
			if (user!=null){
				System.out.println("user not null");
				mav.addObject("u",user);
				mav.addObject("half_path", "users");
				mav.addObject("jsp_name", "userDetails");
				mav.setViewName("manager/index");
				return mav;
			}
		}
		System.out.println("id null");
		mav.addObject("msg","用户不存在");
		mav.setViewName("manager/common/fail");
		return mav;
	}
//不允许删除
	/*@RequestMapping("/delete")
	public ModelAndView  delete(){
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			User u=userService.findUserById(id);
			if(u!=null){
				TopicDto dto=new TopicDto();
				dto.setPublisher(u);
				List<Topic> topics=bbSservice.findAllTopic(dto).getList();
				Set<Topic> topicSet=null;
				if (topics!=null&&topics.size()>0) {
					topicSet=new HashSet<>(topics);
					bbSservice.deleteAllTopic(topicSet);
					System.out.println("topicSet:" + topicSet.size());
				}
				userService.delete(u);

				mav.addObject("msg","删除成功");
				mav.setViewName("redirect:/user/all.do");
			}
			}else{
				mav.addObject("msg", "删除失败");
				mav.setViewName("manager/common/fail");
			}
				return mav;
	}
*/
}
