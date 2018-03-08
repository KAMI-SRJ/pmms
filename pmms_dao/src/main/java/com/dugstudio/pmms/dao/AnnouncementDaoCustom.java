package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.AnnouncementDto;
import com.dugstudio.pmms.dto.CurrentAnnouncementInfoDTO;
import com.dugstudio.pmms.entity.Announcement;
import com.dugstudio.pmms.entity.Page;

import java.util.List;

public interface AnnouncementDaoCustom {
    public Page<Announcement> findAllAnnouncement(AnnouncementDto announcement);
    public Page<Announcement> findAnnouncements(int currentPage,int pageSize);

    public  List<Announcement> queryPreAnnouncementList(CurrentAnnouncementInfoDTO currentAnnouncementInfoDTO);

    public List<Announcement> queryNextAnnouncementList(CurrentAnnouncementInfoDTO currentAnnouncementInfoDTO);
}
