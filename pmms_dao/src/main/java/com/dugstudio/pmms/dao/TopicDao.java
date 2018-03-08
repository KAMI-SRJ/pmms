package com.dugstudio.pmms.dao;


import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Topic;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TopicDao extends TopicDaoCustom, CommonDao<Topic,String> {
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "insert into topic_good values(?1,?2)",nativeQuery = true)
    public int updateTopicGood(String  topicId, String userId);
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "delete from topic_good where (topic_id=?1 or good_id=?1)",nativeQuery = true)
    int deleteTopicGoodByTopicIdOrUserId(String Id);
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "delete from topic_comment where (topic_id=?1 or comment_id=?1)",nativeQuery = true)
    int deleteTopicCommentByTopicOrComment(String id);
}
