package com.natural.controller.customerController;

import com.natural.entity.customer.CustomerEntity;
import com.natural.entity.customer.CustomerRequestEntity;
import com.natural.entity.customer.CustomerResponseEntity;
import com.natural.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class Customer {
    private final CustomerService customerService;

    @Autowired
    public Customer(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping()
    public CustomerResponseEntity getAllCustomers() {
        List<CustomerEntity> customer = customerService.getAllCustomers();
        return new CustomerResponseEntity(customer);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable String id) {
        CustomerEntity customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerRequestEntity request) {
        CustomerEntity createdCustomer = customerService.createCustomer(request.getName(), request.getEmail());
        return ResponseEntity.ok(createdCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String customerId) {
        CustomerEntity customer = customerService.getCustomerById(customerId);
        if (customerId == null || customerId.isEmpty() || customer == null) {
            return ResponseEntity.notFound().build();        }
        else {
            customerService.deleteCustomerById(customerId);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        }
    }
}
