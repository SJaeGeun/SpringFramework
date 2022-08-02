import BankSystem.Currency;
import BankSystem.ExchangeFee;
import BankSystem.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("환전 시스템 테스트")
class exchangeTest{

  @Test
  @DisplayName("WON 환전 테스트")
  void exchangeWON(){
    Money money = ExchangeFee.exchange(new Money(Currency.WON, 3000), "YEN");
    double result = money.getValue();
    assertEquals(300, result);
  }
  @Test
  @DisplayName("DOLLAR 환전 테스트")
  void exchangeDOLLAR(){
    Money money = ExchangeFee.exchange(new Money(Currency.DOLLAR, 5), "YEN");
    double result = money.getValue();
    assertEquals(500, result);
  }
  @Test
  @DisplayName("YEN 환전 테스트")
  void exchangeYEN(){
    Money money = ExchangeFee.exchange(new Money(Currency.YEN, 200), "WON");
    double result = money.getValue();
    assertEquals(2000, result);
  }
}