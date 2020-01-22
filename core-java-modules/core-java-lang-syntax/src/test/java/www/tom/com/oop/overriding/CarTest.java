package www.tom.com.oop.overriding;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class CarTest {
    private Vehicle vehicle;
    private Car car;

    @Before
    public void setUp() throws Exception {
        vehicle=new Vehicle();
        car=new Car();
    }

  /*  @BeforeClass
    public static void beforeClass() throws Exception {
        vehicle=new Vehicle();
        car=new Car();
    }*/

    @Test
    public void whenCalledAccelerate_thenOneAssertion() {
        assertThat(vehicle.accelerate(100))
                .isEqualTo("The vehicle accelerates at : 100 MPH.");
/*    }

    @Test
    public void whenCalledRun_thenOneAssertion() {*/
        assertThat(vehicle.run())
                .isEqualTo("The vehicle is running.");
  /*  }

    @Test
    public void whenCalledStop_thenOneAssertion() {*/
        assertThat(vehicle.stop())
                .isEqualTo("The vehicle has stopped.");
/*    }

    @Test
    public void whenCalledAccelerate_thenOneAssertion() {*/
        assertThat(car.accelerate(80))
                .isEqualTo("The car accelerates at : 80 MPH.");
    }

    @Test
    public void whenCalledRun_thenOneAssertion() {
        assertThat(car.run())
                .isEqualTo("The vehicle is running.");
   /* }

    @Test
    public void whenCalledStop_thenOneAssertion() {*/
        assertThat(car.stop())
                .isEqualTo("The vehicle has stopped.");
    }
    @Test
    public void givenVehicleCarInstances_whenCalledRun_thenEqual() {
        assertThat(vehicle.run()).isEqualTo(car.run());
    }

    @Test
    public void givenVehicleCarInstances_whenCalledStop_thenEqual() {
        assertThat(vehicle.stop()).isEqualTo(car.stop());
    }
    @Test
    public void whenCalledAccelerateWithSameArgument_thenNotEqual() {
        assertThat(vehicle.accelerate(100))
                .isNotEqualTo(car.accelerate(100));
    }
}