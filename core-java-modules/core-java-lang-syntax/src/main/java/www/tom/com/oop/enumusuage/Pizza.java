package www.tom.com.oop.enumusuage;

import lombok.Data;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
@Data
public class Pizza {
    private PizzaStatus status;




    private static EnumSet<PizzaStatus> undeliveredPizzaStatuses =
            EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    EnumMap<Pizza.PizzaStatus, Pizza> map;

    public static EnumMap<PizzaStatus, List<Pizza>>
    groupPizzaByStatus(List<Pizza> pzList) {
        EnumMap<PizzaStatus, List<Pizza>> map = pzList.stream().collect(
                Collectors.groupingBy(Pizza::getStatus,
                        () -> new EnumMap<>(PizzaStatus.class), Collectors.toList()));
        return map;
    }
  /* public static EnumMap<PizzaStatus, List<Pizza>> groupPizzaByStatus(List<Pizza> pizzaList) {
        EnumMap<PizzaStatus, List<Pizza>> pzByStatus =
                new EnumMap<PizzaStatus, List<Pizza>>(PizzaStatus.class);

        for (Pizza pz : pizzaList) {
            PizzaStatus status = pz.getStatus();
            if (pzByStatus.containsKey(status)) {
                pzByStatus.get(status).add(pz);
            } else {
                List<Pizza> newPzList = new ArrayList<Pizza>();
                newPzList.add(pz);
                pzByStatus.put(status, newPzList);
            }
        }
        return pzByStatus;
    }
*/

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

  /*  public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                (s) -> !deliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }*/
    public static List<Pizza> getAllUndeliveredPizzas(List<Pizza> input) {
        return input.stream().filter(
                (s) -> undeliveredPizzaStatuses.contains(s.getStatus()))
                .collect(Collectors.toList());
    }


    public boolean isDeliverable() {
        return false;
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy()
                    .deliver(this);
            this.setStatus(PizzaStatus.DELIVERED);
        }
    }

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

   /* public boolean isDeliverable() {
        return this.status.isReady();
    }*/

    // Methods that set and get the status variable.
}
