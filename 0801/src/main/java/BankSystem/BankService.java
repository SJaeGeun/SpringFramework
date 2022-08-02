package BankSystem;

import org.springframework.beans.factory.annotation.Autowired;

public class BankService {

  public double deposit(ExchangeFee exchangeFee, double value) {
    return exchangeFee.setMoneyValue(exchangeFee.getMoneyValue() + value);
  }

  public double withDraw(ExchangeFee exchangeFee, double value) {
    return exchangeFee.setMoneyValue(exchangeFee.getMoneyValue() - value);
  }
}
