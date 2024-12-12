package com.natural.service;

import com.natural.entity.product.ProductEntity;
import com.natural.entity.product.ProductRequestEntity;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAllProduct();
    ProductEntity createProduct(String name, String description);
    ProductEntity getProductById(String id);
    void deleteProductById(String id);
    ProductEntity updateProduct(String id, ProductRequestEntity updatedProduct);
}
