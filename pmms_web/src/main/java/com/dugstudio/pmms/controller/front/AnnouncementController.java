package com.dugstudio.pmms.controller.front;

import com.dugstudio.pmms.controller.core.BaseController;
import com.dugstudio.pmms.dto.CurrentAnnouncementInfoDTO;
import com.dugstudio.pmms.entity.Announcement;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.service.AnnouncementService;
import com.dugstudio.pmms.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("announcement")
@RequestMapping("/front/announcement")
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
            Page<Announcement> page = announcementService.findAnnouncements(1,10);
            if (page != null) {
                mav.addObject("announcementpage", page);
                mav.setViewName("/front/announcements/page");
            } else {
                mav.addObject("msg", "没有公告");
                mav.setViewName("/public/common/fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
		return mav;
	}
    @RequestMapping("/details")
    public ModelAndView details(){
        ModelAndView mav=new ModelAndView();
        try {
            request.setCharacterEncoding("utf-8");
            String id = request.getParameter("id");
            if(StringUtils.isNotBlank(id)){
              Announcement announcement=  announcementService.findAnnouncementById(id);
              if (announcement!=null){
                  CurrentAnnouncementInfoDTO ca=new CurrentAnnouncementInfoDTO();
                  ca.setAnnouncementDate(announcement.getCreateDate());
                  Page <Announcement> hot_announcement=announcementService.findAnnouncements(1,10);
                  mav.addObject("announcement",announcement);
                  announcement=announcementService.queryPreAnnouncement(ca);
                  mav.addObject("pre",announcement);
                  announcement=announcementService.queryNextAnnouncement(ca);
                  mav.addObject("next",announcement);
                  request.getSession().setAttribute("hot_announcement",hot_announcement);
                  mav.setViewName("front/announcements/details");
                  return mav;
              }


            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return mav;

    }
}
