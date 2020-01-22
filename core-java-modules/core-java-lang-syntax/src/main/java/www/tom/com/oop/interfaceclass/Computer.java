package www.tom.com.oop.interfaceclass;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class Computer implements Electronic {

    @Override
    public int getElectricityUse() {
        return 1000;
    }
}
