package com.benjamin.checklist.domain.service;

import com.benjamin.checklist.domain.model.Checklist;
import com.benjamin.checklist.domain.repository.ChecklistDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ChecklistService {

  @Autowired
  ChecklistDao dao;

  // count用メソッド
  public int count(Date registDate) {
    return dao.count(registDate);
  }

  /**
   * Checklistテーブルに挿入する. 
   * @param checklist ChecklistDTO
   * @return rowNumber insert件数
   */
  public boolean insert(Checklist checklist) {
    // insert実行
    int rowNumber = dao.insertOne(checklist);

    // 判定用変数
    boolean result = false;

    if (rowNumber > 0) {
      // insert成功
      result = true;
    }

    return result;
  }

  /**
   * Checklistテーブルを1件検索する.
   * @param registDate 登録日
   * @return Checklist ChecklistDTOのリスト
   */
  public Checklist selectOne(Date registDate) {
    // selectOne実行
    return dao.selectOne(registDate);
  }

  public List<Checklist> selectMany() {
    // selectMany実行
    return dao.selectMany();
  }

  public boolean updateOne(Checklist checklist) {

    // 1件更新
    int rowNumber = dao.updateOne(checklist);

    // 判定用変数
    boolean result = false;

    if (rowNumber > 0) {
      // update成功
      result = true;
    }

    return result;
  }

  public boolean deleteOne(Date registDate) {

    // 1件削除
    int rowNumber = dao.deleteOne(registDate);

    // 判定用変数
    boolean result = false;

    if (rowNumber > 0) {
      // update成功
      result = true;
    }

    return result;
  }
}
