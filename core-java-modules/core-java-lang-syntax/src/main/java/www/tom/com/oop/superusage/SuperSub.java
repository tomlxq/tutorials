package www.tom.com.oop.superusage;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class SuperSub extends SuperBase {

    public SuperSub(String message) {
        super(message);
    }
    String message = "child class";

    public SuperSub() {
        super.printMessage();
        printMessage();
    }

    @Override
    public void printMessage() {
        System.out.println(message);
    }
}
