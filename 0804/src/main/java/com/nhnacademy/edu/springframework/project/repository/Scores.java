package com.nhnacademy.edu.springframework.project.repository;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Scores {
    void load() throws IOException, CsvValidationException;

    List<Score> findAll();
}
