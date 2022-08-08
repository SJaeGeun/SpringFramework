import static org.junit.jupiter.api.Assertions.assertEquals;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.List;
import nhnacademy.finalproject.JavaConfig;
import nhnacademy.finalproject.tariff.basicTariffRepository;
import nhnacademy.finalproject.tariff.jsonTariffRepository;
import nhnacademy.finalproject.waterbill.WaterBill;
import nhnacademy.finalproject.waterbill.basicWaterUsageChargers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class calculatorTest {
  ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

  basicTariffRepository basicTariffRepository = context.getBean("csvRepository", basicTariffRepository.class);
  jsonTariffRepository jsonTariffRepository = context.getBean("jsonRepository",
      nhnacademy.finalproject.tariff.jsonTariffRepository.class);
  basicWaterUsageChargers basicWaterUsageChargers = context.getBean("Chargers",
      nhnacademy.finalproject.waterbill.basicWaterUsageChargers.class);

  @BeforeEach
  void before() throws CsvValidationException, IOException {
    jsonTariffRepository.DataLoad();
  }

  @Test
  @DisplayName("totalBill 테스트")
  void totalBill(){
    List<WaterBill> waterBills = basicWaterUsageChargers.billCalculation(2000);
    int totalBill = waterBills.get(0).getBillTotal();
    assertEquals(740000, totalBill);
  }
}
