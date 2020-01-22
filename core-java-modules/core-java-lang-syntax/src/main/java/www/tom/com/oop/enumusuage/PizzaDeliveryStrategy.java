package www.tom.com.oop.enumusuage;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public enum PizzaDeliveryStrategy {
    EXPRESS {
        @Override
        public void deliver(Pizza pz) {
            System.out.println("Pizza will be delivered in express mode");
        }
    },
    NORMAL {
        @Override
        public void deliver(Pizza pz) {
            System.out.println("Pizza will be delivered in normal mode");
        }
    };

    public abstract void deliver(Pizza pz);
}
