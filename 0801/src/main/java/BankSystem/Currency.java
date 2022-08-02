package BankSystem;

import org.springframework.beans.factory.annotation.Autowired;

public enum Currency {
  WON(1), DOLLAR(1000), YEN(10);


  public int getCurrencyValue() {
    return currencyValue;
  }

  int currencyValue;
  @Autowired
  Currency(int currencyValue) {
    this.currencyValue = currencyValue;
  }

}
