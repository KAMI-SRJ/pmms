package com.dugstudio.pmms.dao;

import com.dugstudio.pmms.dto.DocumentQueryDto;
import com.dugstudio.pmms.entity.Document;
import com.dugstudio.pmms.entity.Page;

public interface DocumentDaoCustom {

    public Page<Document> findDocumentByPage(DocumentQueryDto documentQueryDto);
}
