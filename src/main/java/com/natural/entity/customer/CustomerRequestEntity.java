package com.natural.entity.customer;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Table
@Entity
public class CustomerRequestEntity {
    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String email;

    @Id
    @Hidden
    private Long id;

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
