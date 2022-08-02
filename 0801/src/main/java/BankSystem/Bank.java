package BankSystem;

import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bank {
  public static void main(String[] args) {

    try (ClassPathXmlApplicationContext context
        = new ClassPathXmlApplicationContext("beans.xml")) {

      ExchangeFee exchangeFee1 = context.getBean("ExchangeFee", ExchangeFee.class);
      BankService bankService1 = context.getBean("BankService", BankService.class);


      Scanner scanner = new Scanner(System.in);
      boolean stop = true;
      while (stop) {
        System.out.println("무엇을 하시겠습니까? (1) 입금 (2) 출금 (3) 환전 (4) 종료");
        int check1 = scanner.nextInt();

        switch (check1) {
          case 1:
            System.out.println("얼마를 입금하시겠습니까?");
            double depositValue = scanner.nextDouble();
            double depoBalance = bankService1.deposit(exchangeFee1, depositValue);
            System.out.println("현재 잔액 : " + depoBalance);
            break;
          case 2:
            System.out.println("얼마를 출금하시겠습니까?");
            while (true) {
              double withDrawValue = scanner.nextDouble();
              if (exchangeFee1.getMoneyValue() > withDrawValue) {
                double drawBalance = bankService1.withDraw(exchangeFee1, withDrawValue);
                System.out.println("현재 잔액 : " + drawBalance);
                break;
              } else
                System.out.println("금액이 너무 큽니다.");
            }
            break;
          case 3:
            exchangeFee1.checkExchange();
            break;
          default:
            stop = false;
        }
      }

    }
  }
}