import static org.junit.jupiter.api.Assertions.*;

import BankSystem.BankService;
import BankSystem.Currency;
import BankSystem.ExchangeFee;
import BankSystem.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankServiceTest {

  ExchangeFee exchangeFee = new ExchangeFee(new Money(Currency.WON, 10000));
  BankService bankService = new BankService();

  @Test
  @DisplayName("입금")
  void deposit() {
    bankService.deposit(exchangeFee,5000);
    assertEquals(exchangeFee.getMoneyValue(),15000);
  }

  @Test
  @DisplayName("출금")
  void withDraw() {
    bankService.withDraw(exchangeFee,5000);
    assertEquals(exchangeFee.getMoneyValue(),5000);
  }
}