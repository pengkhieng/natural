package com.natural.entity.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String email;

    public CustomerEntity() {
        // Default constructor required by JPA
    }

    public CustomerEntity(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = generateId();
    }

    private String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
