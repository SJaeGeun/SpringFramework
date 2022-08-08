package nhnacademy.finalproject;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import nhnacademy.finalproject.report.basicResultReport;
import nhnacademy.finalproject.tariff.TariffRepository;
import nhnacademy.finalproject.tariff.basicTariffRepository;
import nhnacademy.finalproject.tariff.jsonTariffRepository;
import nhnacademy.finalproject.waterbill.WaterBill;
import nhnacademy.finalproject.waterbill.basicWaterUsageChargers;
import org.json.simple.parser.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {

  public static void main(String[] args) throws CsvValidationException, IOException, ParseException {
    List<WaterBill> waterBills = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

//    basicTariffRepository basicTariffRepository = context.getBean("csvRepository", basicTariffRepository.class);
//    basicWaterUsageChargers basicWaterUsageChargers = context.getBean("csvChargers", basicWaterUsageChargers.class);
    jsonTariffRepository jsonTariffRepository = context.getBean("jsonRepository", jsonTariffRepository.class);
    basicWaterUsageChargers jsonWaterUsageChargers = context.getBean("jsonChargers", basicWaterUsageChargers.class);
    basicResultReport basicResultReport = context.getBean("Report", basicResultReport.class);


    jsonTariffRepository.DataLoad();
    int usage;

    while(true) {
      System.out.print("사용량을 입력하세요 >> ");
      usage = scanner.nextInt();
      waterBills = jsonWaterUsageChargers.billCalculation(usage);
      basicResultReport.printReport(waterBills);
    }

  }
}
