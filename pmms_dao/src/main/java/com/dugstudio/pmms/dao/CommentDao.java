package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface CommentDao extends CommonDao<Comment,String> {
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "delete from comment_comment where ( child_id=?1 and parent_id=?2 )",nativeQuery = true)
    int deleteComment_comment(String id, String parentId);
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "insert into comment_good  values(?1,?2)",nativeQuery = true)
    int saveCommentAndGood(String id, String id1);
    @Modifying
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Query(value = "delete from comment_good where ( comment_id=?1 or good_id=?1)",nativeQuery = true)
    int deleteCommentAndGoodByCommentOrGood(String id);
}
