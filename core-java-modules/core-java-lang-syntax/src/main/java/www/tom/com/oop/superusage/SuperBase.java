package www.tom.com.oop.superusage;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class SuperBase {
     String message;

    public SuperBase(String message) {

        this.message = message;
    }

    public SuperBase() {
    }

    protected void printMessage() {
        System.out.println(message);
    }
}
