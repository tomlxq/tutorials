package www.tom.com.oop.overriding;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class Car extends Vehicle {

    @Override
    public String accelerate(long mph) {
        return "The car accelerates at : " + mph + " MPH.";
    }
}
