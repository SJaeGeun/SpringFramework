package BankSystem;

import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

public class ExchangeFee {

  static Money money;

  // Optional을 이용한 널포인터 방지
  public void setMoney(Optional<Money> money) {
    money.ifPresent(it ->this.money = it);
  }

  public double getMoneyValue(){
    return money.getValue();
  }
  public double setMoneyValue(double value){
    ExchangeFee.money.setValue(value);
    return ExchangeFee.money.getValue();
  }

  @Autowired // 생성자 주입 (id가 money인 빈의 값들을 주입받는다)
  public ExchangeFee(@Qualifier("Money") Money money) {
    ExchangeFee.money = money;
  }
  // init-method를 통한 callbacks
  public void init(){
    System.out.println("ExchangeFee init called!!");
  }



  public void checkExchange() {
    Scanner scanner = new Scanner(System.in);
    String changingCurrency;
    System.out.println("환전하고 싶은 통화를 입력하세요.");
    changingCurrency = scanner.next();
    exchange(money,changingCurrency);
    printExchanging();
  }


  public static Money exchange(Money money, String changingCurrency) {
    Currency changingCurrencyName = Currency.valueOf(changingCurrency);
    Currency currencyName = money.getCurrency();
    double exchangeFee = 0.99f;

    money.setCurrency(changingCurrencyName);
    money.setValue((money.getValue() * (double) currencyName.getCurrencyValue())*exchangeFee / (double) changingCurrencyName.getCurrencyValue());

    return roundsMoney(money);
  }
  public static Money roundsMoney(Money money){
    if(money.getCurrency() == Currency.DOLLAR){
      money.setValue(Math.round(money.getValue()*100)/100.0);
    }
    else if(money.getCurrency() == Currency.WON){
      money.setValue(Math.round(money.getValue()/10)*10);
    }
    else {
      money.setValue(Math.round(money.getValue()*10)/10.0);
    }
    return money;
  }

  public void printExchanging(){
    System.out.println("수수료는 1% 입니다.");
    System.out.println("환전된 금액은 " + money.getValue() + " 입니다.");
  }
}

