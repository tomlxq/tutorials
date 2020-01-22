package www.tom.com.oop.constructuers;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
@Data
public class BankAccount {
    String name;
    LocalDateTime opened;
    double balance;
    public BankAccount() {
        this.name = "";
        this.opened = LocalDateTime.now();
        this.balance = 0.0d;
    }
    public BankAccount(String name, LocalDateTime opened, double balance) {
        this.name = name;
        this.opened = opened;
        this.balance = balance;
    }
    public BankAccount(BankAccount other) {
        this.name = other.name;
        this.opened = LocalDateTime.now();
        this.balance = 0.0f;
    }
    public BankAccount(String name) {
        this(name, LocalDateTime.now(), 0.0f);
    }
    @Override
    public String toString() {
        return String.format("%s, %s, %f",
                this.name, this.opened.toString(), this.balance);
    }
}
