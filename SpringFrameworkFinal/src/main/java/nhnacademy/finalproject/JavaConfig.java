package nhnacademy.finalproject;

import nhnacademy.finalproject.dataparsing.CsvDataParser;
import nhnacademy.finalproject.dataparsing.DataParser;
import nhnacademy.finalproject.dataparsing.JsonDataParser;
import nhnacademy.finalproject.exetimer.ExeTimer;
import nhnacademy.finalproject.exetimer.ExecutionTimer;
import nhnacademy.finalproject.report.ResultReport;
import nhnacademy.finalproject.report.basicResultReport;
import nhnacademy.finalproject.tariff.TariffRepository;
import nhnacademy.finalproject.tariff.basicTariffRepository;
import nhnacademy.finalproject.tariff.jsonTariffRepository;
import nhnacademy.finalproject.waterbill.WaterUsageChargesService;
import nhnacademy.finalproject.waterbill.basicWaterUsageChargers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
  @ExeTimer
  @Bean(name = "Parser")
  public DataParser dataParser(){
    return new JsonDataParser();
  }
//  @ExeTimer
//  @Bean(name = "csvRepository")
//  public TariffRepository TariffRepository() {
//    return new basicTariffRepository(dataParser());}
  @ExeTimer
  @Bean(name = "jsonRepository")
  public TariffRepository TariffRepository() {
    return new jsonTariffRepository(dataParser());}
  @ExeTimer
  @Bean(name = "csvChargers")
  public WaterUsageChargesService waterUsageChargesService(){
    return new basicWaterUsageChargers(TariffRepository());
  }
  @ExeTimer
  @Bean(name = "jsonChargers")
  public basicWaterUsageChargers basicWaterUsageChargers(){
    return new basicWaterUsageChargers(TariffRepository());
  }
  @ExeTimer
  @Bean(name = "Report")
  public ResultReport basicResultReport(){
    return new basicResultReport();
  }

  @Bean
  public ExecutionTimer executionTimer(){
    return new ExecutionTimer();}
}
