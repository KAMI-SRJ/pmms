package com.dugstudio.pmms.service;

import com.dugstudio.pmms.dao.CommentDao;
import com.dugstudio.pmms.dao.TopicDao;
import com.dugstudio.pmms.dto.TopicDto;
import com.dugstudio.pmms.entity.Comment;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class BBSservice {
@Autowired
private TopicDao topicDao;
@Autowired
private CommentDao commentDao;
	
@Autowired
public void setTopicDao(TopicDao topicDao) {
	this.topicDao = topicDao;
}
@Autowired
public void setCommentDao(CommentDao commentDao) {
	this.commentDao = commentDao;
}

	public Page<Topic> findAllTopic(TopicDto topic) {
		return topicDao.queryTopicPage(topic);
	}
	public boolean save(Topic topic) {
		System.out.println("save topic");
	topicDao.save(topic);
		return true;
	}
	public Topic findTopicById(String id) {
		return topicDao.findOne(id);
		
	}
	public void deleteTopic(Topic topic) {
		System.out.println("deleteTopic"+topic);
	   topicDao.delete(topic);
	   
	}
	public void saveComment(Comment comment) {
		System.out.println(" sasveComment");
		commentDao.save(comment);
		
	}
	public Comment findCommentById(String id) {
		return commentDao.findOne(id);
	}
	public void deleteComment(Comment comment) {
		System.out.println("deleteComment");
		commentDao.delete(comment);
		
	}
	public void deleteAllTopic(Set<Topic> topics){
		topicDao.deleteInBatch(topics);
	}
	public void deleteAllComment(Set<Comment> comments) {
		System.out.println("delete all"+comments.size());
		commentDao.deleteInBatch(comments);
	}

	public int insertTopicGood(String  topicId,String userId) {
		return topicDao.updateTopicGood(topicId,userId);
	}

	public int deleteTopicGoodByTopicIdOrUserId(String  id) {
		return topicDao.deleteTopicGoodByTopicIdOrUserId(id);
	}

	public int deleteTopicCommentByTopicOrComment(String id) {
		return topicDao.deleteTopicCommentByTopicOrComment(id);
	}

	public int deleteComment_comment(String id, String parentId) {
		return commentDao.deleteComment_comment(id,parentId);
	}

	public int saveCommentAndGood(String id, String id1) {
		return commentDao.saveCommentAndGood(id,id1);
	}

	public int deleteCommentAndGood(String id) {
		return commentDao.deleteCommentAndGoodByCommentOrGood(id);
	}
}
