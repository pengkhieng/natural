package com.natural.repository.product;

import com.natural.entity.product.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM ProductEntity p WHERE p.id = :id")
    void deleteById(String id);

    @Query("SELECT p FROM ProductEntity p WHERE p.id = :id")
    ProductEntity getProductById(String id);
}
