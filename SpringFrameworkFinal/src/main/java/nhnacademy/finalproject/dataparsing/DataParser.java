package nhnacademy.finalproject.dataparsing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataParser {

  String pathParsing() throws IOException, CsvValidationException;

}
