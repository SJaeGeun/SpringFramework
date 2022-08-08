package nhnacademy.finalproject.report;

import java.util.List;
import nhnacademy.finalproject.waterbill.WaterBill;

public class basicResultReport implements ResultReport {

  @Override
  public void printReport(List<WaterBill> waterBills) {
    for (int i = 0; i < 5; i++) {
      System.out.println(waterBills.get(i).toString());
    }
    waterBills.clear();
  }
}
