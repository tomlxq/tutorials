import org.junit.jupiter.api.Test;
import www.tom.com.oop.superusage.SuperSub;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class SuperSubTest {
    @Test
    void test() {
        SuperSub child = new SuperSub("message from the child class");
    }
}