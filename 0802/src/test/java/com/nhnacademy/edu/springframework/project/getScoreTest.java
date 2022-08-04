package com.nhnacademy.edu.springframework.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.nhnacademy.edu.springframework.project.service.JavaConfig;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class getScoreTest {

  ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
  CsvDataLoadService csvDataLoadService = context.getBean("csvData", CsvDataLoadService.class);
  DefaultGradeQueryService defaultGradeQueryService = context.getBean("QueryService", DefaultGradeQueryService.class);


  @BeforeEach
  void before() throws CsvValidationException, IOException {
    csvDataLoadService.loadAndMerge();
  }

  @Test
  @DisplayName("학생 이름에 의한 점수 반환")
  void getScoreByStudentName(){
    int score = defaultGradeQueryService.getScoreByStudentName("H").get(0).getScore();
    assertEquals(90, score);
  }

  @Test
  @DisplayName("학생 번호에 의한 점수 반환")
  void getScoreByStudentSeq(){
    int score = defaultGradeQueryService.getScoreByStudentSeq(11).getScore();
    assertEquals(20, score);
  }
}
