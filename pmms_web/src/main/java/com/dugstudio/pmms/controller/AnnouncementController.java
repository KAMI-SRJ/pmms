package com.dugstudio.pmms.controller;

import com.dugstudio.pmms.annotation.Before;
import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.AnnouncementDto;
import com.dugstudio.pmms.entity.Announcement;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.interceptor.AdminInterceptor;
import com.dugstudio.pmms.service.AnnouncementService;
import com.dugstudio.pmms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/announcement")
@Before(AdminInterceptor.class)
public class AnnouncementController extends BaseController {
	@Autowired
    private AnnouncementService announcementService;
	@Autowired
	private UserService userService;
	@RequestMapping("/all")
	public ModelAndView findAllAnnouncement(){
        System.out.println("all-----------------------------------ccc");
        ModelAndView mav= new ModelAndView();
        try {
            request.setCharacterEncoding("utf-8");
            String title = request.getParameter("title");
            String content = request.getParameter("description");
            String isTop = request.getParameter("isTop");
            String publisher = request.getParameter("publisher");
            String currentPage=request.getParameter("currentPage");
            String pageSize=request.getParameter("pageSize");
            String type=request.getParameter("type");
            String keyword=request.getParameter("keyword");
            AnnouncementDto announcement=new AnnouncementDto();
            announcement.setTitle(title);
            announcement.setContent(content);
            announcement.setPublisher(publisher);
            if (StringUtils.isNotBlank(type)){
                if("title".equals(type)){
                    announcement.setTitle(keyword);
                }
                if ("publisher".equals(type)){
                    announcement.setPublisher(keyword);
                }
            }
            if (StringUtils.isNotBlank(currentPage)){
                announcement.setCurrentPage(Integer.parseInt(currentPage));
            }else{
                announcement.setCurrentPage(1);
            }
            if (StringUtils.isNotBlank(pageSize)){
                announcement.setPageSize(Integer.parseInt(pageSize));
            }else{
                announcement.setPageSize(10);
            }
            if(StringUtils.isNotBlank(isTop)) {
                System.out.println("istop:"+isTop);
                announcement.setIsTop(1);
            }else{
                announcement.setIsTop(0);
            }
            Page<Announcement> page = announcementService.findAllAnnouncement(announcement);
            if (page != null) {
                mav.addObject("page", page);
                mav.addObject("half_path", "announcements");
                mav.addObject("jsp_name","page");
                mav.setViewName("manager/index");
            } else {
                mav.addObject("msg", "没有公告");
                mav.addObject("half_path", "announcements");
                mav.setViewName("/manager/common/fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
		return mav;
	}

	@RequestMapping("/addOrUpdate")
	public ModelAndView  add(){
ModelAndView mav=new ModelAndView();
try {
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String up=request.getParameter("up_jsp");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String isTop = request.getParameter("isTop");
	String publisher = request.getParameter("publisher");
    Announcement announcement=null;

    if(StringUtils.isNotBlank(id)){
        System.out.println("anno!=null");
        announcement =announcementService.findAnnouncementById(id);
        System.out.println("delete before announcement:"+announcement.getId());

        System.out.println("delete after announcement:"+announcement.getId());
        announcement.setUpdateDate(new Date());
        mav.addObject("announcement",announcement);
    }else{
        announcement=new Announcement();
        announcement.setCreateDate(new Date());
    }
    if(StringUtils.isNotBlank(up)){
        System.out.println(up);
        mav.setViewName("/manager/announcements/upload");
        return mav;
    }
	if(StringUtils.isNotBlank(title)){
        announcement.setTitle(title);
        System.out.println("------title---------"+title);
    }
    if(StringUtils.isNotBlank(content)){
        System.out.println("--------content-----------"+content);
        announcement.setContent(content.trim());
    }
    if(StringUtils.isNotBlank(publisher)){
    	if(userService.findUserByUsername(publisher)){
			announcement.setPublisher(publisher);

		}
	}
	if(StringUtils.isNotBlank(isTop)) {
        System.out.println("istop:"+isTop);
        announcement.setIsTop(1);
	}else{
		announcement.setIsTop(0);
	}
	    announcementService.delete(announcement);
	if(announcementService.save(announcement)!=null){
        System.out.println("announ::::::"+announcement);
        mav.setViewName("redirect:/announcement/all.do");
		return mav;
	}

    }catch (Exception e){
        e.printStackTrace();
        }
	mav.addObject("half_path", "./common");
	mav.addObject("jsp_name", "fail");
	mav.setViewName("/manager/index");
	return mav;

	}

	@RequestMapping("/delete")
	public ModelAndView  delete(){
		ModelAndView mav=new ModelAndView();
		String id=request.getParameter("id");
		if(StringUtils.isNotBlank(id)){
			Announcement a=announcementService.findAnnouncementById(id);
			if(a!=null){
				announcementService.delete(a);
				mav.addObject("msg","删除成功");
				System.out.println("delete--------------------------------------");
				mav.setViewName("redirect:/announcement/all.do");
			}
			}else{
				mav.addObject("msg", "删除失败");
				mav.setViewName("manager/common/fail");
			}
				return mav;
	}
	
}
