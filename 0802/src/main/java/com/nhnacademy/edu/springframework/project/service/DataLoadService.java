package com.nhnacademy.edu.springframework.project.service;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public interface DataLoadService {
    void loadAndMerge() throws CsvValidationException, IOException;
}
