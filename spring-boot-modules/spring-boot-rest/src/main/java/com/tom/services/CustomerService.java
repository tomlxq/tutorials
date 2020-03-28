package com.tom.services;

import java.util.List;

import com.tom.persistence.model.Customer;

public interface CustomerService {

    List<Customer> allCustomers();

    Customer getCustomerDetail(final String id);

}
