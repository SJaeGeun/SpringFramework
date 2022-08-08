package nhnacademy.finalproject;

import java.util.Comparator;
import nhnacademy.finalproject.dataparsing.WaterworksData;

public class dataComparator implements Comparator<WaterworksData> {

  @Override
  public int compare(WaterworksData waterworksData1, WaterworksData waterworksData2){
    if(waterworksData1.getBaseAmount() > waterworksData2.getBaseAmount()){
      return 1;
    } else if(waterworksData1.getBaseAmount() < waterworksData2.getBaseAmount()){
      return -1;
    }
    return 0;
  }
}
