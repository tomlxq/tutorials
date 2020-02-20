package com.tom.tostring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/8
 */
@Slf4j
class CustomerTest {
    @Test
    public void toString1() {
       Customer customer = new Customer();
       log.info("{}", customer.toString());
    }

    @Test
    public void givenPrimitive_whenToString_thenCustomerDetails() {
        CustomerPrimitiveToString customer = new CustomerPrimitiveToString();
        customer.setFirstName("Rajesh");
        customer.setLastName("Bhojwani");
        customer.setBalance(110);
        assertEquals("Customer [balance=110, getFirstName()=Rajesh, getLastName()=Bhojwani]",
                customer.toString());
    }

    @Test
    public void givenComplex_whenToString_thenCustomerDetails() {
        CustomerComplexObjectToString customer = new CustomerComplexObjectToString();
        // .. set up customer as before
        Order order = new Order();
        order.setOrderId("A1111");
        order.setDesc("Game");
        order.setStatus("In-Shiping");
        customer.setOrder(order);
        customer.setFirstName("Rajesh");
        customer.setLastName("Bhojwani");
        assertEquals("Customer [order=Order [orderId=A1111, desc=Game, value=0], " +
                "getFirstName()=Rajesh, getLastName()=Bhojwani]", customer.toString());
    }
    @Test
    public void givenArray_whenToString_thenCustomerDetails() {
        CustomerArrayToString customer = new CustomerArrayToString();
        Order order = new Order();
        order.setOrderId("A1111");
        order.setDesc("Game");
        order.setStatus("In-Shiping");
        customer.setFirstName("Rajesh");
        customer.setLastName("Bhojwani");
        customer.setOrders(new Order[] { order });

        assertEquals("Customer [orders=[Order [orderId=A1111, desc=Game, value=0]], " +
                "getFirstName()=Rajesh, getLastName()=Bhojwani]", customer.toString());
    }

    @Test
    public void givenWrapperCollectionStrBuffer_whenToString_thenCustomerDetails() {
        CustomerWrapperCollectionToString customer = new CustomerWrapperCollectionToString();
        Order order = new Order();
        order.setOrderId("A1111");
        order.setDesc("Game");
        order.setStatus("In-Shiping");
        customer.setFirstName("Rajesh");
        customer.setLastName("Bhojwani");

        StringBuffer fullname = new StringBuffer();
        fullname.append(customer.getLastName()+ ", " + customer.getFirstName());
        customer.setFullname(fullname);
        customer.setScore(8);
        customer.setOrders(Arrays.asList("Book", "Pen"));
        assertEquals("Customer [score=8, orders=[Book, Pen], fullname=Bhojwani, Rajesh, getFirstName()=Rajesh, "
                + "getLastName()=Bhojwani]", customer.toString());
    }
}