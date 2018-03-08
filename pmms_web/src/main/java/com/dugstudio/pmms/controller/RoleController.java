package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.annotation.Clear;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.RoleQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Resource;
import com.dugstudio.pmms.entity.Role;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.ResourceService;
import com.dugstudio.pmms.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;

@Controller
@RequestMapping("/role")
@Before(AdminInterceptor.class)
public class RoleController extends BaseController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	@RequestMapping("/all")
	@Clear()
	public ModelAndView findAllRoles(){
		String currentPage=request.getParameter("currentPage");
		String pageSize=request.getParameter("pageSize");
		ModelAndView mav=new ModelAndView();
		RoleQueryDto rqt=new RoleQueryDto();
		try {
			request.setCharacterEncoding("utf-8");
			if(StringUtils.isNotBlank(currentPage)){
				rqt.setCurrentPage(Integer.parseInt(currentPage));
			}
			else {
				rqt.setCurrentPage(1);
			}
			if(StringUtils.isNotBlank(pageSize)){
				rqt.setPageSize(Integer.parseInt(pageSize));
			}else{
				rqt.setPageSize(10);
			}
			Page<Role> page=roleService.findAllRoles(rqt);
			if(page!=null){
				mav.addObject("page", page);
				mav.addObject("half_path", "roles");
				mav.addObject("jsp_name", "page");
				mav.setViewName("manager/index");
			}else{
				mav.setViewName("manager/common/fail");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	//添加角色
	@RequestMapping("/add")
	public ModelAndView  add(){
		ModelAndView mav=new ModelAndView();
		try{
			request.setCharacterEncoding("UTF-8");
			String name=request.getParameter("name");
			String []res=request.getParameterValues("resource");
			String type=request.getParameter("type");
			HashSet<Resource> resources=null;
			if(type!=null){
				mav.addObject("half_path", "roles");
				mav.addObject("jsp_name","add");
				mav.setViewName("manager/index");
				return mav;
			}
			if(StringUtils.isNotBlank(name)){
				Role r=roleService.findRoleByName(name);
				if(r==null){
					if(res!=null&&res.length>0){
						resources=new HashSet<Resource>();
						Resource rece=null;
						r=new Role();
						r.setName(name);
						r.setCreateDate(new Date());
						for(String re:res){
							rece=resourceService.findResourceByName(re);
							if(rece!=null){
								rece.setName(re);
								resources.add(rece);
								System.out.println("rece:"+rece);
							}
						}
						r.setResource(resources);
					}
					Role ro=roleService.add(r);
					if(ro!=null){
						mav.addObject("half_path", "roles");
						mav.addObject("jsp_name","page");
						mav.addObject("msg","添加成功");
						mav.setViewName("redirect:/role/all.do");
						return mav;

					}
				}
			}
			mav.addObject("msg", "添加失败");
			mav.setViewName("manager/common/fail");

		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	//删除角色
	@RequestMapping("/delete")
	public ModelAndView  delete(){
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			Role r=roleService.findRoleById(id);
			if(r!=null){
				roleService.delete(r);
				mav.addObject("msg","删除成功");
				mav.addObject("half_path", "roles");
				mav.addObject("jsp_name", "page");
				mav.setViewName("redirect:/role/all.do");
			}
		}else{
			mav.addObject("msg", "删除失败");
			mav.setViewName("manager/common/fail");
		}
		return mav;
	}
}
