package com.natural.service;

import com.natural.entity.product.ProductEntity;
import com.natural.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity createProduct(String name, String description) {
        ProductEntity product = new ProductEntity(name, description);
        return productRepository.save(product);
    }
    @Override
    public ProductEntity getProductById(String id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void deleteProductById(String id) {

        productRepository.deleteById(id);
    }


}
