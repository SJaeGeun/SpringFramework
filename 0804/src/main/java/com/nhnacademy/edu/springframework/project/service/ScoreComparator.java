package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Student;
import java.util.Comparator;

public class ScoreComparator implements Comparator<Student> {

  @Override
  public int compare(Student student1, Student student2){
    if (student1.getScore().getScore() > student2.getScore().getScore()){
      return 1;
    } else if (student1.getScore().getScore() < student2.getScore().getScore()){
      return -1;
    }
    return 0;
  }
}
