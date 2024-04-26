package com.natural.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;

    // Constructors, getters, and setters
    public ProductEntity() {
        // Default constructor
    }

    public ProductEntity(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = generateId();
    }


    private String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }



    // Getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
