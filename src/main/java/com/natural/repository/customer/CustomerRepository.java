package com.natural.repository.customer;

import com.natural.entity.customer.CustomerEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CustomerEntity c WHERE c.id = :customerId")
    void deleteById(String customerId);

    @Query("SELECT c FROM CustomerEntity c WHERE c.id = :customerId")
    CustomerEntity getCustomerById(String customerId);
}