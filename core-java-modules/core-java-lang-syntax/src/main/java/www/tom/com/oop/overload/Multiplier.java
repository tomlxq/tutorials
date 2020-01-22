package www.tom.com.oop.overload;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class Multiplier {

    public int multiply(int a, int b) {
        return a * b;
    }
    /*public double multiply(int a, int b) {
        return a * b;
    }*/
    public double multiply(int a, long b) {
        return a * b;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }


    public double multiply(double a, double b) {
        return a * b;
    }
}
