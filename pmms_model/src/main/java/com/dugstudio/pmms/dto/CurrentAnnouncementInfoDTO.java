package com.dugstudio.pmms.dto;

import java.util.Date;

public class CurrentAnnouncementInfoDTO {
	
	//公告ID
	private String announcementId;
	
	//时间
	private Date announcementDate;
	
	//当前公告的排序
	private Integer orderNo;

	public String getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(String announcementId) {
		this.announcementId = announcementId;
	}

	public Date getAnnouncementDate() {
		return announcementDate;
	}

	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}

