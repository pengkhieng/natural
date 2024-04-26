package com.natural.service.serviceImpl;


import com.natural.entity.CustomerEntity;
import com.natural.repository.CustomerRepository;
import com.natural.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity getCustomerById(String customerId) {
        return customerRepository.getCustomerById(customerId);
    }

    @Override
    public CustomerEntity createCustomer(String name, String email) {
        CustomerEntity customer = new CustomerEntity(name, email);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}