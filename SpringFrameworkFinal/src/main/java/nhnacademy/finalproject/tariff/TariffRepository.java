package nhnacademy.finalproject.tariff;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.List;
import nhnacademy.finalproject.dataparsing.WaterworksData;
import org.json.simple.parser.ParseException;

public interface TariffRepository {
  void DataLoad() throws CsvValidationException, IOException;

  List<WaterworksData> dataByUsage(int usage);



}
