package www.tom.com.oop.staticusage;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class Singleton  {
    private Singleton() {}

    private static class SingletonHolder {
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
