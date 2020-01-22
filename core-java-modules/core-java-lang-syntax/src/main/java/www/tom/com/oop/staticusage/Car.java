package www.tom.com.oop.staticusage;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Data
@NoArgsConstructor
public class Car {
    private String name;
    private String engine;

    public static int numberOfCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    // getters and setters
}
