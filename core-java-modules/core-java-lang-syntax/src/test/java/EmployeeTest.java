import org.junit.Test;
import www.tom.com.oop.inheritance.ArmoredCar;
import www.tom.com.oop.inheritance.BMW;
import www.tom.com.oop.inheritance.Employee;
import www.tom.com.oop.inheritance.SpaceCar;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/1/19
 */
public class EmployeeTest {
    @Test
    public void test(){
        Employee e1 = new Employee("Shreya", new ArmoredCar());
        Employee e2 = new Employee("Paul", new SpaceCar());
        Employee e3 = new Employee("Pavni", new BMW());
    }
}
