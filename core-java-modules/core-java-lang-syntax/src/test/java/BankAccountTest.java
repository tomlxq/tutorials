import org.junit.Test;
import www.tom.com.oop.constructuers.BankAccount;

import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
public class BankAccountTest {
    @Test
    public void test(){
        BankAccount account = new BankAccount();
        account.toString();
    }
    @Test
    public void test2() {
        LocalDateTime opened = LocalDateTime.of(2018, Month.JUNE, 29, 06, 30, 00);
        BankAccount account = new BankAccount("Tom", opened, 1000.0f);
        account.toString();
    }
    @Test
    public void test3() {
        LocalDateTime opened = LocalDateTime.of(2018, Month.JUNE, 29, 06, 30, 00);
        BankAccount account = new BankAccount("Tim", opened, 1000.0f);
        BankAccount newAccount = new BankAccount(account);

        assertThat(account.getName()).isEqualTo(newAccount.getName());
        assertThat(account.getOpened()).isNotEqualTo(newAccount.getOpened());
        assertThat(newAccount.getBalance()).isEqualTo(0.0f);
    }
}
