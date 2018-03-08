package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.core.CommonDao;
import com.dugstudio.pmms.entity.Document;
import org.springframework.data.jpa.repository.Query;

public interface DocumentDao extends CommonDao<Document, String> , DocumentDaoCustom {
	@Query("select d from Document d where d.name=?1")
	public Document findDocumentByName(String name);

}
