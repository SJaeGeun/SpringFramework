package BankSystem;

public class Money {

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public Currency getCurrency() {
    return currency;
  }

  public double getValue() {
    return value;
  }

  public Money(Currency currency, double value) {
    this.currency = currency;
    if(value > 0) this.value = value;
    else {
      System.out.println("유효하지 않은 금액입니다.");
      System.exit(1);
    }
  }
  private Currency currency;
  private double value;

}
