package nhnacademy.finalproject.tariff;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import nhnacademy.finalproject.dataparsing.DataParser;
import nhnacademy.finalproject.dataparsing.WaterworksData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.ls.LSOutput;

public class basicTariffRepository implements TariffRepository{

  DataParser dataParser;
  public basicTariffRepository(DataParser dataParser) {
    this.dataParser = dataParser;
  }

  public DataParser getDataParser() {
    return dataParser;
  }

  private final List<WaterworksData> waterWoksData = new ArrayList<>();

  private List<WaterworksData> dataByUsage = new ArrayList<>();

  public List<WaterworksData> getWaterWoksData() {
    return waterWoksData;
  }

  public List<WaterworksData> getDataByUsage() {
    return dataByUsage;
  }
  @Override
  public void DataLoad() throws CsvValidationException, IOException {
    String filePath = dataParser.pathParsing();
    FileReader fileReader = new FileReader(filePath);
    CSVReader csvReader = new CSVReader(fileReader);

    String[] data;

    while ((data = csvReader.readNext()) != null){
      for (int i =0; i<data.length; i+=8){
        waterWoksData.add(new WaterworksData(Integer.parseInt(data[i]), data[i+1], data[i+2],
            Integer.parseInt(data[i+3]), Integer.parseInt(data[i+4]), Integer.parseInt(data[i+5]),
            Integer.parseInt(data[i+6])));
      }
    }
  }

  @Override
  public List<WaterworksData> dataByUsage(int usage) {
    for(int i=0; i<waterWoksData.size(); i++){
      if (usage > waterWoksData.get(i).getStartSection()){
        if (usage < waterWoksData.get(i).getEndSection()){
          dataByUsage.add(waterWoksData.get(i));
        }
      }
    }
    return dataByUsage;
  }
}
