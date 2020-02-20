/**
 * In Java, we can also use the clone method to create an object from an existing object. However, the copy constructor has some advantages over the clone method:
 *
 * The copy constructor is much easier to implement. We do not need to implement the Cloneable interface and handle CloneNotSupportedException.
 * The clone method returns a general Object reference. Therefore, we need to typecast it to the appropriate type.
 * We can not assign a value to a final field in the clone method. However, we can do so in the copy constructor.
 *
 * @author TomLuo
 * @date 2020/2/9
 */
package com.tom.copyconstructor;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

public class EmployeeUnitTest {
    @Test
    public void givenCopyConstructor_whenDeepCopy_thenDistinct() {
        Date d1 = new Date(123);
        Employee e1 = new Employee(1, "tom", d1);
        Employee e2 = new Employee(e1);
        assertEquals(d1, e1.getStartDate());
        assertEquals(d1, e2.getStartDate());

        d1.setTime(456);
        assertEquals(d1, e1.getStartDate());
        assertNotEquals(d1, e2.getStartDate());
    }

    @Test
    public void givenCopyMethod_whenCopy_thenDistinct() {
        Date d1 = new Date(123);
        Employee e1 = new Employee(1, "tom", d1);
        Employee e2 = e1.copy();
        assertEquals(d1, e1.getStartDate());
        assertEquals(d1, e2.getStartDate());

        d1.setTime(456);
        assertEquals(d1, e1.getStartDate());
        assertNotEquals(d1, e2.getStartDate());
    }
}
