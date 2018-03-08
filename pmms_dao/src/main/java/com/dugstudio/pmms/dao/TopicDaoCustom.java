package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.TopicDto;
import com.dugstudio.pmms.entity.Page;
import com.dugstudio.pmms.entity.Topic;

public interface TopicDaoCustom {
	public Page<Topic> queryTopicPage(TopicDto topic);

}
