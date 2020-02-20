package www.tom;

import com.tom.stringtoenum.PizzaStatusEnum;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Converting Strings to Enums in Java
 *
 * @author TomLuo
 * @date 2020/1/23
 */
public class PizzaTest {

    @Test
    public void whenConvertedIntoEnum_thenGetsConvertedCorrectly() {

        String pizzaEnumValue = "READY";
        PizzaStatusEnum pizzaStatusEnum
                = PizzaStatusEnum.valueOf(pizzaEnumValue);
        assertTrue(pizzaStatusEnum == PizzaStatusEnum.READY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenConvertedIntoEnum_thenThrowsException() {

        String pizzaEnumValue = "rEAdY";
        PizzaStatusEnum pizzaStatusEnum
                = PizzaStatusEnum.valueOf(pizzaEnumValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenConvertedIntoEnum_thenThrowsException2() {
        String pizzaEnumValue = "invalid";
        PizzaStatusEnum pizzaStatusEnum = PizzaStatusEnum.valueOf(pizzaEnumValue);
    }
}