package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Singleton;
import com.nhnacademy.edu.springframework.project.repository.Student;
import com.nhnacademy.edu.springframework.project.repository.Students;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class CsvDataLoadService implements DataLoadService {

    public CsvDataLoadService(CsvStudents csvStudents, CsvScores csvScores) {
        this.csvStudents = csvStudents;
        this.csvScores = csvScores;
    }

    public CsvStudents getCsvStudents() {
        return csvStudents;
    }

    public CsvScores getCsvScores() {
        return csvScores;
    }

    CsvStudents csvStudents = Singleton.getStudentInstance();
    CsvScores csvScores = new CsvScores();

    @Override
    public void loadAndMerge() throws CsvValidationException, IOException {
        csvStudents.load();
        csvScores.load();
        csvStudents.merge(csvScores.getScores());
        for(Student student: csvStudents.getStudents().values()){
            System.out.print(student.toString());
        }
    }
}
