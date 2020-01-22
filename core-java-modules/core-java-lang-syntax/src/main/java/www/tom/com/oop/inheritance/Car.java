package www.tom.com.oop.inheritance;

import lombok.Data;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Data
public class Car {
    int wheels;
    String model;
    void start() {
        // Check essential parts
    }
    public static String msg() {
        return "Car";
    }
}