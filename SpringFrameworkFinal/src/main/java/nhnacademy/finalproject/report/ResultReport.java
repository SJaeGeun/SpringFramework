package nhnacademy.finalproject.report;

import java.util.List;
import nhnacademy.finalproject.waterbill.WaterBill;

public interface ResultReport {
  void printReport(List<WaterBill> waterBills);
}
