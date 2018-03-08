package com.dugstudio.pmms.service;

import com.dugstudio.pmms.dao.AnnouncementDao;
import com.dugstudio.pmms.dto.AnnouncementDto;
import com.dugstudio.pmms.dto.CurrentAnnouncementInfoDTO;
import com.dugstudio.pmms.entity.Announcement;
import com.dugstudio.pmms.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
	@Autowired
	private AnnouncementDao announcementDao;

	 public Page<Announcement> findAllAnnouncement(AnnouncementDto announcement) {
		return announcementDao.findAllAnnouncement(announcement);
	}
	public Page<Announcement> findAnnouncements(int currentPage,int pageSize){
	 	return announcementDao.findAnnouncements(currentPage,pageSize);
	}

	public Announcement findAnnouncementById(String id) {
		return announcementDao.findOne(id);
	}

	public void delete(Announcement a) {
		announcementDao.delete(a);
	}

    public Announcement save(Announcement announcement) {
	 	return announcementDao.save(announcement);
    }

	public Announcement queryNextAnnouncement(CurrentAnnouncementInfoDTO currentAnnouncementInfoDTO){
		Announcement article = null;
		List<Announcement> articleList = this.announcementDao.queryNextAnnouncementList(currentAnnouncementInfoDTO);
		if(articleList != null && articleList.size() > 0){
			article = articleList.get(0);
		}
		return article;
	}

	public Announcement queryPreAnnouncement(CurrentAnnouncementInfoDTO currentAnnouncementInfoDTO){
		Announcement article = null;
		List<Announcement> articleList = this.announcementDao.queryPreAnnouncementList(currentAnnouncementInfoDTO);
		if(articleList != null && articleList.size() > 0){
			article = articleList.get(0);
		}
		return article;
	}
}
