package www.tom.com.oop.classandobject;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/18
 */
public class FancyCar extends Vehicle implements Driveable {
    @Override
    public String honk() {
        return "beep";
    }
}
