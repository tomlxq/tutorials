package www.tom.com.oop.interfaceclass;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public interface Transform {

    void transform();
    default void printSpecs(){
        System.out.println("Transform Specification");
    }
}
