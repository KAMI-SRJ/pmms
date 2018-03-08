package com.dugstudio.pmms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dugstudio.pmms.dao.ProfessionDao;
import com.dugstudio.pmms.entity.Profession;

@Service
public class ProfessionService {
	  @Autowired
      private ProfessionDao professionDao;

	public Profession findProfessionByName(String profession) {
		//profession="%"+profession+"%";
		return professionDao.findProfessionByName(profession);
	}
      
}
