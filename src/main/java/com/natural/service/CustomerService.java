package com.natural.service;

import com.natural.entity.customer.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAllCustomers();
    CustomerEntity createCustomer(String name, String email);
    CustomerEntity getCustomerById(String customerId);
    void deleteCustomerById(String customerId);
}
