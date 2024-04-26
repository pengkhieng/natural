package com.natural.entity.product;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;



@Table
@Entity
public class ProductRequestEntity {
    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String description;

    @Id
    @Hidden
    private Long id;



    // Getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
