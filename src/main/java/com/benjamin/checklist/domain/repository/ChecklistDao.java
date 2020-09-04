package com.benjamin.checklist.domain.repository;

import com.benjamin.checklist.domain.model.Checklist;
import java.util.Date;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface ChecklistDao {

  // Checklistテーブルの件数を取得
  public int count(Date registDate) throws DataAccessException;

  // Checklistテーブルにデータを1件insert
  public int insertOne(Checklist checklist) throws DataAccessException;

  // Checklistテーブルのデータを1件取得
  public Checklist selectOne(Date registDate) throws DataAccessException;

  // Checklistテーブルの全デー1件取得
  public List<Checklist> selectMany() throws DataAccessException;

  // Checklistテーブルを1件更新
  public int updateOne(Checklist checklist) throws DataAccessException;

  // Checklistテーブルを1件削除
  public int deleteOne(Date registDate) throws DataAccessException;
}
