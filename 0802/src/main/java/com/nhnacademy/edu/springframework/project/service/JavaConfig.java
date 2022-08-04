package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class JavaConfig {
  @Bean(name = "score")
  public CsvScores csvScores(){
    return new CsvScores();
  }
  @Bean(name = "students")
  public CsvStudents csvStudents(){
    return new CsvStudents();
  }

  @Bean(name = "csvData")
  public CsvDataLoadService csvDataLoadService(){
    return new CsvDataLoadService(csvStudents(), csvScores());
  }

  @Bean(name = "QueryService")
  public DefaultGradeQueryService defaultGradeQueryService(){
    return new DefaultGradeQueryService(csvDataLoadService());
  }

  @Bean(name = "StudentService")
  public DefaultStudentService defaultStudentService(){
    return new DefaultStudentService(csvDataLoadService());
  }
}
