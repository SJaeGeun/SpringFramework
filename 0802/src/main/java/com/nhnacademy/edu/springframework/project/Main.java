package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import com.nhnacademy.edu.springframework.project.repository.Student;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) throws CsvValidationException, IOException {
        DataLoadService dataLoadService = new CsvDataLoadService();
        System.out.println("<load와 merge가 된 후의 학생 목록>");
        dataLoadService.loadAndMerge();

        DefaultStudentService studentService = new DefaultStudentService();
        Collection<Student> passedStudents = studentService.getPassedStudents();
        System.out.println("\n<시험을 통과한 학생들>");
        System.out.println(passedStudents);

        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();
        System.out.println("\n<시험 점수별로 내림차순 정렬>");
        System.out.println(orderedStudents);

        DefaultGradeQueryService defaultGradeQueryService = new DefaultGradeQueryService();
        String name = "A";
        System.out.println("<"+name + "학생들의 점수>");
        List<Score> scoreByName = defaultGradeQueryService.getScoreByStudentName(name);
        System.out.println(scoreByName +"\n");

        int seq = 8;
        System.out.println("<학생 번호" + seq + "의 점수>");
        Score scoreBySeq = defaultGradeQueryService.getScoreByStudentSeq(seq);
        System.out.println(scoreBySeq);
//        CsvStudents csvStudents = new CsvStudents();
//        csvStudents.load();
    }
}
