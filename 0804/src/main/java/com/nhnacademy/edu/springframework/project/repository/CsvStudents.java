package com.nhnacademy.edu.springframework.project.repository;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/** TODO 3 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/

/**
 * TODO 7 :
 * singleton 클래스를 만드세요.
 */
public class CsvStudents implements Students {
    private final Map<Integer,Student> students = new HashMap<>();


    // TODO 6 : student.csv 파일에서 데이터를 읽어 students 에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException, CsvValidationException {
        String filePath = "C:/Users/82109/OneDrive/바탕 화면/NHN/week6/0804/src/main/resources/data/student.csv";
        FileReader fileReader = new FileReader(filePath);
        CSVReader studentCSV = new CSVReader(fileReader);
        String[] studentInfor;

        int studentNumber = 1;

        while((studentInfor = studentCSV.readNext()) !=null){
            for(int i = 0; i<studentInfor.length; i+=2){
                students.put(studentNumber,
                    new Student(Integer.parseInt(studentInfor[i]), studentInfor[i+1]));

                studentNumber += 1;
            }
        }
//        System.out.println(students.get(1));
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    @Override
    public Collection<Student> findAll() {
        return this.students.values();
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     */
    @Override
    public void merge(Collection<Score> scores) {
        for(Score score : scores) {
            students.get(score.getStudentSeq()).setScore(score);
        }
    }

}
