package nhnacademy.finalproject.dataparsing;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class JsonDataParser implements DataParser{
  @Override
  public String pathParsing() throws IOException, CsvValidationException {

    String filePath = "C:/Users/82109/OneDrive/바탕 화면/NHN/Spring Framework/SpringFrameworkFinal/src/main/resources/Tariff_20220331.json";

    return filePath;
  }
}
