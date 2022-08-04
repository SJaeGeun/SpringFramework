package com.nhnacademy.edu.springframework.project.repository;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public interface Students {
    void load() throws IOException, CsvValidationException;

    Collection<Student> findAll();

    void merge(Collection<Score> scores);
}
