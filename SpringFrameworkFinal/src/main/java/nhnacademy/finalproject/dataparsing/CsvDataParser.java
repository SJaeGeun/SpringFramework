package nhnacademy.finalproject.dataparsing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class CsvDataParser implements DataParser {

  @Override
  public String pathParsing() throws IOException, CsvValidationException {

    String filePath = "C:/Users/82109/OneDrive/바탕 화면/NHN/Spring Framework/SpringFrameworkFinal/src/main/resources/Tariff_20220331.csv";

    return filePath;
  }
}
