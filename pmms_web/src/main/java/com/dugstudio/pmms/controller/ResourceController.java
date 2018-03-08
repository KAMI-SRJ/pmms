package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.ResourceQueryDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Resource;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.ResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;


@Controller
@RequestMapping("/resource")
@Before(AdminInterceptor.class)
public class ResourceController extends BaseController {
	@Autowired
	private ResourceService resourceService;
	@RequestMapping("/all")
	public ModelAndView findAllResources(){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentPage=request.getParameter("currentPage");
		String pageSize=request.getParameter("pageSize");
		ModelAndView mav=new ModelAndView();
		ResourceQueryDto rqt=new ResourceQueryDto();
		if(StringUtils.isNotBlank(currentPage)){
			rqt.setCurrentPage(Integer.parseInt(currentPage));
		}else{
			rqt.setCurrentPage(1);
		}
		if(StringUtils.isNotBlank(pageSize)){
			rqt.setPageSize(Integer.parseInt(pageSize));
		}else{
			rqt.setPageSize(10);
		}
		Page<Resource> page=resourceService.findAllResorces(rqt);
		if(page!=null){
		mav.addObject("page", page);
		mav.addObject("half_path", "resources");
		mav.addObject("jsp_name", "page");
		mav.setViewName("manager/index");
		}else{
		mav.setViewName("manager/common/fail");
		}
		return mav;
	}
	@RequestMapping("/delete")
	public ModelAndView  delete(){
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			Resource r=resourceService.findResourceById(id);
			if(r!=null){
				resourceService.delete(r);
				mav.addObject("msg","删除成功");
				mav.addObject("jsp_name", "page");
				mav.setViewName("redirect:/resource/all.do");
			}
			}else{
				mav.addObject("msg", "删除失败");
				mav.setViewName("manager/common/fail");
			}
				return mav;
	}
}
