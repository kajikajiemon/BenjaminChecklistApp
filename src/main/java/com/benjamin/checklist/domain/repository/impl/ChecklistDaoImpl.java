package com.benjamin.checklist.domain.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.benjamin.checklist.domain.model.Checklist;
import com.benjamin.checklist.domain.repository.ChecklistDao;

@Repository
public class ChecklistDaoImpl implements ChecklistDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbc;

  // Checklistテーブルの件数を取得
  @Override
  public int count(Date registDate) throws DataAccessException {
    // SQL文
    String sql = "SELECT COUNT(*)" + " FROM checklist" + " WHERE regist_date = :registDate";

    // パラメーター生成
    SqlParameterSource params = new MapSqlParameterSource().addValue("registDate", registDate);

    // 全件取得してカウント
    return jdbc.queryForObject(sql, params, Integer.class);
  }

  // Checklistテーブルにデータを1件insert
  @Override
  public int insertOne(Checklist checklist) throws DataAccessException {

    // SQL文
    String sql = "INSERT INTO checklist(" + "regist_date," + " habit_no01," + " habit_no02," + " habit_no03,"
        + " habit_no04," + " habit_no05," + " habit_no06," + " habit_no07," + " habit_no08," + " habit_no09,"
        + " habit_no10," + " habit_no11," + " habit_no12," + " habit_no13)" + " VALUES(" + " :registDate,"
        + " :habitNo01," + " :habitNo02," + " :habitNo03," + " :habitNo04," + " :habitNo05," + " :habitNo06,"
        + " :habitNo07," + " :habitNo08," + " :habitNo09," + " :habitNo10," + " :habitNo11," + " :habitNo12,"
        + " :habitNo13)";

    // パラメータ
    SqlParameterSource params = new MapSqlParameterSource().addValue("registDate", checklist.getRegistDate())
        .addValue("habitNo01", checklist.isHabitNo01()).addValue("habitNo02", checklist.isHabitNo02())
        .addValue("habitNo03", checklist.isHabitNo03()).addValue("habitNo04", checklist.isHabitNo04())
        .addValue("habitNo05", checklist.isHabitNo05()).addValue("habitNo06", checklist.isHabitNo06())
        .addValue("habitNo07", checklist.isHabitNo07()).addValue("habitNo08", checklist.isHabitNo08())
        .addValue("habitNo09", checklist.isHabitNo09()).addValue("habitNo10", checklist.isHabitNo10())
        .addValue("habitNo11", checklist.isHabitNo11()).addValue("habitNo12", checklist.isHabitNo12())
        .addValue("habitNo13", checklist.isHabitNo13());

    // SQL実行
    return jdbc.update(sql, params);
  }

  @Override
  public Checklist selectOne(Date registDate) throws DataAccessException {

    // SQL文
    String sql = "SELECT * FROM checklist WHERE regist_date = :registDate";

    // パラメーター
    SqlParameterSource params = new MapSqlParameterSource().addValue("registDate", registDate);

    // RowMapperの生成
    RowMapper<Checklist> rowMapper = new BeanPropertyRowMapper<Checklist>(Checklist.class);

    // SQL実行
    return jdbc.queryForObject(sql, params, rowMapper);
  }

  @Override
  public List<Checklist> selectMany() throws DataAccessException {

    // SQL文
    String sql = "SELECT * FROM checklist";

    // パラメーター
    SqlParameterSource params = new MapSqlParameterSource();

    // RowMapperの生成
    RowMapper<Checklist> rowMapper = new BeanPropertyRowMapper<Checklist>(Checklist.class);

    // SQL実行(queryメソッドで複数件返却可能)
    return jdbc.query(sql, params, rowMapper);
  }

  // Checklistテーブルを1件更新
  @Override
  public int updateOne(Checklist checklist) throws DataAccessException {

    // 1件更新
    String sql = "UPDATE checklist" + " SET" + " habit_no01 = :habitNo01," + " habit_no02 = :habitNo02,"
        + " habit_no03 = :habitNo03," + " habit_no04 = :habitNo04," + " habit_no05 = :habitNo05,"
        + " habit_no06 = :habitNo06," + " habit_no07 = :habitNo07," + " habit_no08 = :habitNo08,"
        + " habit_no09 = :habitNo09," + " habit_no10 = :habitNo10," + " habit_no11 = :habitNo11,"
        + " habit_no12 = :habitNo12," + " habit_no13 = :habitNo13" + " WHERE regist_date = :registDate";

    // パラメータ
    SqlParameterSource params = new MapSqlParameterSource().addValue("registDate", checklist.getRegistDate())
        .addValue("habitNo01", checklist.isHabitNo01()).addValue("habitNo02", checklist.isHabitNo02())
        .addValue("habitNo03", checklist.isHabitNo03()).addValue("habitNo04", checklist.isHabitNo04())
        .addValue("habitNo05", checklist.isHabitNo05()).addValue("habitNo06", checklist.isHabitNo06())
        .addValue("habitNo07", checklist.isHabitNo07()).addValue("habitNo08", checklist.isHabitNo08())
        .addValue("habitNo09", checklist.isHabitNo09()).addValue("habitNo10", checklist.isHabitNo10())
        .addValue("habitNo11", checklist.isHabitNo11()).addValue("habitNo12", checklist.isHabitNo12())
        .addValue("habitNo13", checklist.isHabitNo13());

    // SQL実行
    return jdbc.update(sql, params);
  }

  // Checklistテーブルを1件削除
  @Override
  public int deleteOne(Date registDate) throws DataAccessException {

    // SQL文
    String sql = "DELETE FROM checklist WHERE regist_date = :registDate";

    // パラメーター
    SqlParameterSource params = new MapSqlParameterSource().addValue("registDate", registDate);

    // SQL実行
    int rowNumber = jdbc.update(sql, params);

    return rowNumber;
  }
}
