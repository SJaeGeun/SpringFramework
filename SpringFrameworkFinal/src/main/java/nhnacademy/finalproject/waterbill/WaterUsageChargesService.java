package nhnacademy.finalproject.waterbill;

import java.util.List;

public interface WaterUsageChargesService {
  List<WaterBill> billCalculation(int usage);
}
