package com.natural.service;

import com.natural.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAllCustomers();

    CustomerEntity getCustomerById(String customerId);

    CustomerEntity createCustomer(String name, String email);

    void deleteCustomerById(String customerId);
}
