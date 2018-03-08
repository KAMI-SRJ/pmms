package com.dugstudio.pmms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//公告
@Entity
@Table(name="announcement")
public class Announcement extends BaseEntity {

	private static final long serialVersionUID = -6780427612925957430L;
	private String title;//主题
	private String content;//内容
	private String publisher;//发布人
	private Integer isTop;//1置顶
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(columnDefinition = "text")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="publisher",length=20)
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	//默认不置顶  置顶为1
	@Column(name="isTop",columnDefinition="INT default 0")
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	@Override
	public String toString() {
		return "Announcement [title=" + title + ", content=" + content + ", publisher=" + publisher + ", isTop=" + isTop
				+ "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
