package com.benjamin.checklist.domain.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.benjamin.checklist.domain.repository.ChecklistDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChecklistDaoImplTest {

  @Autowired
  ChecklistDao dao;
  
  @Test
  public void countTest1() {
    Date registDate = new Date(); // 今日の日付
    // カウント件数が0件であることを確認
    assertEquals(dao.count(registDate), 0);
  }
}
