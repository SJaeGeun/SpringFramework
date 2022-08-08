package nhnacademy.finalproject.tariff;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nhnacademy.finalproject.Json;
import nhnacademy.finalproject.dataparsing.DataParser;
import nhnacademy.finalproject.dataparsing.WaterworksData;

public class jsonTariffRepository implements TariffRepository{
  DataParser dataParser;

  public jsonTariffRepository(DataParser dataParser) {
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
    File file = new File(filePath);
    ObjectMapper mapper = new ObjectMapper();
    List<Json> jsonList = mapper.readValue(file, new TypeReference<List<Json>>() {});
    for(Json json : jsonList){
      waterWoksData.add(new WaterworksData(json.getSeq(), json.getLocal(), json.getSector(),
          json.getLevel(), json.getStartSection(), json.getEndSection(), json.getBaseAmount()));
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
