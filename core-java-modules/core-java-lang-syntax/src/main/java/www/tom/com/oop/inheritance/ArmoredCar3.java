package www.tom.com.oop.inheritance;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class ArmoredCar3 extends Car implements Floatable, Flyable {

    public void aMethod() {
        //System.out.println(duration); // won't compile
        System.out.println(Floatable.duration); // outputs 10
        System.out.println(Flyable.duration); // outputs 20
    }

    @Override
    public void floatOnWater() {

    }
}
