package www.tom.com.oop.finalclass;

import www.tom.com.oop.constructuers.BankAccount;

import java.time.LocalDateTime;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
public class Transaction {
    final BankAccount bankAccount;
    final LocalDateTime date;
    final double amount;

    public Transaction(BankAccount account, LocalDateTime date, double amount) {
        this.bankAccount = account;
        this.date = date;
        this.amount = amount;
    }
}
