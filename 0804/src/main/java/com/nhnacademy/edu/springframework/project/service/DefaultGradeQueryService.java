package com.nhnacademy.edu.springframework.project.service;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Singleton;
import com.nhnacademy.edu.springframework.project.repository.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultGradeQueryService implements GradeQueryService {


    CsvDataLoadService csvDataLoadService;
    Map<Integer, Student> students;
    @Autowired
    public DefaultGradeQueryService(CsvDataLoadService csvDataLoadService) {
        this.csvDataLoadService = csvDataLoadService;
        this.students = csvDataLoadService.getCsvStudents().getStudents();
    }

    @Override
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        List<Score> scoreByName = new ArrayList<>();
        for(Student student : students.values()){
            if (student.getName().equals(name)){
                scoreByName.add(student.getScore());
            }
        }
        return scoreByName;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학생 번호로 점수를 반환합니다.
        Score scoreBySeq = null;
        for(Student student : students.values()){
            if(student.getSeq() == seq){
                scoreBySeq = student.getScore();
            }
        }
        return scoreBySeq;
    }
}
