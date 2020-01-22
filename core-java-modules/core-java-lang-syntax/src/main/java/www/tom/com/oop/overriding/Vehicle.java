package www.tom.com.oop.overriding;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class Vehicle {

    public String accelerate(long mph) {
        return "The vehicle accelerates at : " + mph + " MPH.";
    }

    public String stop() {
        return "The vehicle has stopped.";
    }

    public String run() {
        return "The vehicle is running.";
    }
}