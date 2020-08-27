package com.benjamin.checklist.domain.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benjamin.checklist.domain.model.Checklist;
import com.benjamin.checklist.domain.repository.ChecklistDao;

@Transactional
@Service
public class ChecklistService {

	@Autowired
	ChecklistDao dao;

	// count用メソッド
	public int count(Date registDate) {
		return dao.count(registDate);
	}
	
	// insert用メソッド
	public boolean insert(Checklist checklist) {
		
		// insert実行
		int rowNumber = dao.insertOne(checklist);
		
		// 判定用変数
		boolean result = false;
		
		if(rowNumber > 0) {
			// insert成功
			result = true;
		}
		
		return result;
	}

	public boolean updateOne(Checklist checklist) {
		
		// 1件更新
		int rowNumber = dao.updateOne(checklist);
		
		// 判定用変数
		boolean result = false;
		
		if(rowNumber > 0) {
			// update成功
			result = true;
		}
		
		return result;
	}
	
}
