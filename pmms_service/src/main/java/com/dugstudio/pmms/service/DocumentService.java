package com.dugstudio.pmms.service;

import com.dugstudio.pmms.dto.DocumentQueryDto;
import com.dugstudio.pmms.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dugstudio.pmms.dao.DocumentDao;
import com.dugstudio.pmms.entity.Document;

@Service
public class DocumentService{
	@Autowired
    private DocumentDao documentDao;
	public Document findDocumentByName(String logImageName) {
		return documentDao.findDocumentByName(logImageName);
	}

	public boolean saveDocument(Document doc) {
		if(documentDao.save(doc)!=null)
		return true;
		else{
			return false;
		}
	}


    public Page<Document> findDocumentByPage(DocumentQueryDto documentQueryDto) {
		return documentDao.findDocumentByPage(documentQueryDto);
    }

	public Document findDocumentById(String docId) {
		return documentDao.findOne(docId);
	}

    public void delete(Document doc) {
		System.out.println("docu  delete dao");
		documentDao.delete(doc);
    }
}
