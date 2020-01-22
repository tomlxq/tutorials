package www.tom.com.oop.interfaceclass.multipieInheritances;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */




public class Car implements Fly, Transform {

    @Override
    public void fly() {
        System.out.println("I can Fly!!");
    }

    @Override
    public void transform() {
        System.out.println("I can Transform!!");
    }
}
