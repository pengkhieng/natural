package com.natural.controller.productController;

import com.natural.entity.product.ProductEntity;
import com.natural.entity.product.ProductRequestEntity;
import com.natural.entity.product.ProductResponseEntity;
import com.natural.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class Product {

    private final ProductService productService;

    @Autowired
    public Product(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public ProductResponseEntity getAllProducts() {
        List<ProductEntity> products = productService.getAllProduct();
        return new ProductResponseEntity(products);
    }
    @PostMapping()
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductRequestEntity request) {
        ProductEntity createdProduct = productService.createProduct(request.getName(), request.getDescription());
        return ResponseEntity.ok(createdProduct);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getCustomerById(@PathVariable String id) {
        ProductEntity product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
        ProductEntity product = productService.getProductById(id);
        if (id == null || id.isEmpty() || product == null) {
            return ResponseEntity.notFound().build();        }
        else {
            productService.deleteProductById(id);
            return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String id, @RequestBody ProductRequestEntity updatedProduct) {
        return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
    }

}
