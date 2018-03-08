package com.dugstudio.pmms.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="document")
public class Document extends BaseEntity {
	private static final long serialVersionUID = -5066336654301399314L;
	private String name;//名称
	private String path;//上传路径
	private User publisher;//发布人
	private Double score;//得分
	private String teacher;//批改老师
	private String comment;//老师评语
	private Date AuditDate;
	private String description;//关于文件的描述
	private Integer type;//文件类型默认0：0-->心得体会，1-->思想汇报，2-->学习资料
	@Column(columnDefinition="text")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="type",columnDefinition="INT default 0")
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Column(length=50)
	public String getName() {
		return name;
	}
	@Column(columnDefinition = "text")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(columnDefinition="DOUBLE default 0.0")
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="publisher",nullable=false)
    public User getPublisher() {
        return this.publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    @Column(length=20)
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Column(name="audit_date")
	public Date getAuditDate() {
		return AuditDate;
	}
	public void setAuditDate(Date auditDate) {
		AuditDate = auditDate;
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return "Document [name=" + name +  ", path=" + path + ", publisher=" + publisher + ", score="
				+ score + ", teacher=" + teacher + ", AuditDate=" + AuditDate + ", description=" + description
				+ ", type=" + type +"comment"+comment+ "]";
	}
	
	
}
