package www.tom.com.oop.interfaceclass;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public interface Electronic {

    // Constant variable
    String LED = "LED";

    // Abstract method
    int getElectricityUse();

    // Static method
    static boolean isEnergyEfficient(String electtronicType) {
        if (electtronicType.equals(LED)) {
            return true;
        }
        return false;
    }

    //Default method
    default void printDescription() {
        System.out.println("Electronic Description");
    }
}
