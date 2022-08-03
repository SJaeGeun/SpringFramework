package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Singleton;
import com.nhnacademy.edu.springframework.project.repository.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class DefaultStudentService implements StudentService {
    Map<Integer, Student> students = Singleton.getStudentMapInstance();
    @Override
    public Collection<Student> getPassedStudents() {
        // TODO 1 : pass 한 학생만 반환하도록 수정하세요.
        Collection<Student> passedStudent = new ArrayList<>();
        for(Student student : students.values()){
            if (!student.getScore().isFail()){
                passedStudent.add(student);
            }
        }
        return passedStudent;
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        // TODO 4 : 성적 순으로 학생 정보를 반환합니다.
        List<Student> orderStudent = new ArrayList<>();
        orderStudent.addAll(students.values());
        Collections.sort(orderStudent, new ScoreComparator().reversed());
        return orderStudent;
    }
}
