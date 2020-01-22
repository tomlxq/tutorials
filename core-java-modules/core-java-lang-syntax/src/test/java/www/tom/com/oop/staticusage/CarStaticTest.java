package www.tom.com.oop.staticusage;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class CarStaticTest {
    @Test
    public void whenNumberOfCarObjectsInitialized_thenStaticCounterIncreases() {
        new Car("Jaguar", "V8");
        new Car("Bugatti", "W16");

        assertEquals(2, Car.numberOfCars);
    }
}