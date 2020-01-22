package www.tom.com.oop.inheritance;

import www.tom.com.oop.interfaceclass.multipieInheritances.Fly;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class ArmoredCar2 extends Car implements Floatable, Fly {
    @Override
    public void floatOnWater() {
        System.out.println("I can float!");
    }
    @Override
    public void fly() {
        System.out.println("I can fly!");
    }
}