package www.tom.com.oop.finalusuage;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class CatTest {
    @Test
    public void test() {
        Cat cat = new Cat();
        cat.setWeight(1);

        assertEquals(1, cat.getWeight());
    }
}