package com.tom.service;

import com.tom.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> findCustomer(String id);

    void updateCustomer(Customer customer);
}
