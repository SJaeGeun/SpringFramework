package nhnacademy.finalproject.waterbill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nhnacademy.finalproject.dataComparator;
import nhnacademy.finalproject.dataparsing.WaterworksData;
import nhnacademy.finalproject.tariff.TariffRepository;
import nhnacademy.finalproject.tariff.basicTariffRepository;

public class basicWaterUsageChargers implements WaterUsageChargesService{

  List<WaterworksData> dataByUsage;

  private final List<WaterBill> waterBills = new ArrayList<>();
  TariffRepository TariffRepository;

  public basicWaterUsageChargers(TariffRepository TariffRepository) {
    this.TariffRepository = TariffRepository;
  }

  @Override
  public List<WaterBill> billCalculation(int usage) {
    dataByUsage = TariffRepository.dataByUsage(usage);

    List<WaterworksData> orderData = new ArrayList<>();
    orderData.addAll(dataByUsage);
    dataByUsage.clear();
    Collections.sort(orderData, new dataComparator());
      for (int i = 0; i<orderData.size(); i++) {
        waterBills.add(new WaterBill(orderData.get(i).getLocal(), orderData.get(i).getSector(),
            orderData.get(i).getBaseAmount(), orderData.get(i).getBaseAmount() * usage));
      }
    return waterBills;
  }
}
