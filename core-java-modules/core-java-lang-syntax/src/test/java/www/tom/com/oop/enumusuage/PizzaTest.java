package www.tom.com.oop.enumusuage;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class PizzaTest {
    @Test
    public void givenPizaOrder_whenDelivered_thenPizzaGetsDeliveredAndStatusChanges() {
        Pizza pz = new Pizza();
        pz.setStatus(Pizza.PizzaStatus.READY);
        pz.deliver();
        assertTrue(pz.getStatus() == Pizza.PizzaStatus.DELIVERED);
    }

}