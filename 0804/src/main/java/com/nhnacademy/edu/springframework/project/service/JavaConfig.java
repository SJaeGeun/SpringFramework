package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.exetimer.ExeTimer;
import com.nhnacademy.edu.springframework.project.exetimer.ExecutionTimer;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
@EnableAspectJAutoProxy
public class JavaConfig {
  @Bean(name = "score")
  @ExeTimer
  public CsvScores csvScores(){
    return new CsvScores();
  }
  @ExeTimer
  @Bean(name = "students")
  public CsvStudents csvStudents(){
    return new CsvStudents();
  }
  @ExeTimer
  @Bean(name = "csvData")
  public CsvDataLoadService csvDataLoadService(){
    return new CsvDataLoadService(csvStudents(), csvScores());
  }
  @ExeTimer
  @Bean(name = "QueryService")
  public DefaultGradeQueryService defaultGradeQueryService(){
    return new DefaultGradeQueryService(csvDataLoadService());
  }
  @ExeTimer
  @Bean(name = "StudentService")
  public DefaultStudentService defaultStudentService(){
    return new DefaultStudentService(csvDataLoadService());
  }
  @Bean
  public ExecutionTimer executionTimer(){
    return new ExecutionTimer();
  }
}
