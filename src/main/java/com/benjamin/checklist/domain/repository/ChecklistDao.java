package com.benjamin.checklist.domain.repository;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.benjamin.checklist.domain.model.Checklist;

public interface ChecklistDao {

	// Checklistテーブルの件数を取得
	public int count(Date registDate) throws DataAccessException;
	
	// Checklistテーブルにデータを1件insert
	public int insertOne(Checklist checklist) throws DataAccessException;

	// Checklistテーブルを1件更新
	public int updateOne(Checklist checklist) throws DataAccessException;
}
