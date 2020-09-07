package com.benjamin.checklist.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.benjamin.checklist.domain.model.Checklist;
import com.benjamin.checklist.domain.model.ChecklistForm;
import com.benjamin.checklist.domain.service.ChecklistService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChecklistController {

  @Autowired
  private ChecklistService checklistService;

  @GetMapping("/checklist")
  public String getChecklist(@ModelAttribute ChecklistForm form, Model model) {

    model.addAttribute("title", "ベンジャミン・フランクリンの十三徳");

    // MAPのセット、取得のテスト
    Map<String, String> map = new HashMap<>();
    map.put("a", "1");
    map.put("b", "2");

    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());

       // SLF4J + logback テスト
      log.trace("trace");
      log.debug("debug");
      log.info("info");
      log.warn("warn");
      log.debug("error");
    }

    // checklist.htmlに画面遷移
    return "checklist/checklist";
  }

  @PostMapping("/checklist")
  public String postSignUp(@ModelAttribute @Validated ChecklistForm form, BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return getChecklist(form, model);
    }

    // 更新用変数
    Checklist checklist = new Checklist();

    checklist.setRegistDate(form.getRegistDate()); // 登録日
    checklist.setHabitNo01(form.isHabitNo01()); // 習慣01
    checklist.setHabitNo02(form.isHabitNo02()); // 習慣02
    checklist.setHabitNo03(form.isHabitNo03()); // 習慣03
    checklist.setHabitNo04(form.isHabitNo04()); // 習慣04
    checklist.setHabitNo05(form.isHabitNo05()); // 習慣05
    checklist.setHabitNo06(form.isHabitNo06()); // 習慣06
    checklist.setHabitNo07(form.isHabitNo07()); // 習慣07
    checklist.setHabitNo08(form.isHabitNo08()); // 習慣08
    checklist.setHabitNo09(form.isHabitNo09()); // 習慣09
    checklist.setHabitNo10(form.isHabitNo10()); // 習慣10
    checklist.setHabitNo11(form.isHabitNo11()); // 習慣11
    checklist.setHabitNo12(form.isHabitNo12()); // 習慣12
    checklist.setHabitNo13(form.isHabitNo13()); // 習慣13

    // 登録、更新判定処理
    int count = checklistService.count(form.getRegistDate());

    if (count == 0) {
      // ユーザー登録処理
      boolean result = checklistService.insert(checklist);

      if (result == true) {
        System.out.println("insert成功");
      } else {
        System.out.println("insert失敗");
      }
    } else {
      // ユーザー更新処理
      boolean result = checklistService.updateOne(checklist);

      if (result == true) {
        System.out.println("update成功");
      } else {
        System.out.println("update失敗");
      }
    }

    // checklist.htmlにリダイレクト
    return "redirect:/checklist";
  }

  // Debug用
  @GetMapping("/checklist_test")
  public String getChecklistTest(@ModelAttribute ChecklistForm form, Model model) throws ParseException {
    // 任意の日付文字列
    String strDate = "2020/08/28 00:00:00";

    // 取り扱う日付の形にフォーマット設定
    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

    // Date型に変換( DateFromatクラスのperse() )
    Date registDate = sdformat.parse(strDate);

    // コンソールに結果を出力
    System.out.println("DEBUG出力:selectOne");
    System.out.println(checklistService.selectOne(registDate));
    System.out.println("DEBUG出力:selectMany");
    List<Checklist> list = checklistService.selectMany();
    for (Checklist data : list) {
      System.out.println(data);
    }

    // checklist.htmlに画面遷移
    return "checklist/checklist";
  }

}
