package com.nhnacademy.edu.springframework.project.repository;

import java.util.List;
import java.util.Map;

public class Singleton {
  private static CsvStudents csvStudents;

  private Singleton() {}

  static{
    try{
      csvStudents = new CsvStudents();
    } catch (Exception e){
      throw new RuntimeException("싱글턴 인스턴스 생성중 오류가 발생했다.");
    }
  }
  public static Map<Integer, Student> getStudentMapInstance(){
    return csvStudents.getStudents();
  }

  public static CsvStudents getStudentInstance() {
    return csvStudents;
  }
}
