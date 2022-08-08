package nhnacademy.finalproject.waterbill;

import nhnacademy.finalproject.dataparsing.WaterworksData;

public class WaterBill {
  String city;
  String sector;
  int unitPrice;
  int billTotal;

  public WaterBill(String city, String sector, int unitPrice, int billTotal) {
    this.city = city;
    this.sector = sector;
    this.unitPrice = unitPrice;
    this.billTotal = billTotal;
  }

//  public WaterBill(WaterworksData waterworksData) {
//  }

  public String getCity() {
    return city;
  }

  public String getSector() {
    return sector;
  }

  public int getUnitPrice() {
    return unitPrice;
  }

  public int getBillTotal() {
    return billTotal;
  }

  public void setBillTotal(int billTotal) {
    this.billTotal = billTotal;
  }

  @Override
  public String toString() {
    return "WaterBill{" +
        "city='" + city + '\'' +
        ", sector='" + sector + '\'' +
        ", unitPrice=" + unitPrice +
        ", billTotal=" + billTotal +
        '}';
  }
}
