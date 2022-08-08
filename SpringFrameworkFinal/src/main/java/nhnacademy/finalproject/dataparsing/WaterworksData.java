package nhnacademy.finalproject.dataparsing;

public class WaterworksData {
  private int seq, level, startSection, endSection, baseAmount;
  private String local;
  private String sector;

  public int getSeq() {
    return seq;
  }

  public int getLevel() {
    return level;
  }

  public int getStartSection() {
    return startSection;
  }

  public int getEndSection() {
    return endSection;
  }


  public int getBaseAmount() {
    return baseAmount;
  }

  public String getLocal() {
    return local;
  }

  public String getSector() {
    return sector;
  }

  public WaterworksData(int seq, String local, String sector, int level,
      int startSection, int endSection, int baseAmount) {
    this.seq = seq;
    this.local = local;
    this.sector = sector;
    this.level = level;
    this.startSection = startSection;
    this.endSection = endSection;
    this.baseAmount = baseAmount;

  }

  @Override
  public String toString() {
    return "WaterworksData{" +
        "seq=" + seq +
        ", local='" + local + '\'' +
        ", sector='" + sector + '\'' +
        ", level=" + level +
        ", startSection=" + startSection +
        ", endSection=" + endSection +
        ", baseRate=" + baseAmount +
        '}';
  }
}
