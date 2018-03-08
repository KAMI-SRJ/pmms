package com.dugstudio.pmms.entity;

import javax.persistence.*;
import java.util.Set;

@Table(name="comment")
@Entity
public class Comment extends BaseEntity {

	private Topic topic;
	private String content;
	private int status;
	private Set<User> goods;
	private Set<Comment>sets;
	private User publisher;
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name = "comment_good",
			joinColumns = {@JoinColumn(name = "comment_id")},
			inverseJoinColumns = {@JoinColumn(name = "good_id")})
	public Set<User> getGoods() {
		return goods;
	}

	public void setGoods(Set<User> goods) {
		this.goods = goods;
	}

	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name = "comment_comment",
			joinColumns = {@JoinColumn(name = "parent_id")},
			inverseJoinColumns = {@JoinColumn(name = "child_id")})
	public Set<Comment> getSets() {
		return sets;
	}

	public void setSets(Set<Comment> sets) {
		this.sets = sets;
	}

	@ManyToOne
	@JoinColumn(name="topic_id")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@Column(nullable=false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="status",precision=1,columnDefinition="INT default 0")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="publisher")
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Comment [topic=" + topic + ", content=" + content + ", status=" + status
				+ ", publisher=" + publisher + "]";
	}
}
