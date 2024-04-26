package com.natural.entity.product;

import javax.swing.*;
import java.util.List;

public class ProductResponseEntity {
    private List<ProductEntity> data;
    private int count;

    public ProductResponseEntity(List<ProductEntity> data) {
        this.data = data;
        this.count = data.size();
    }

    public List<ProductEntity> getData() {
        return data;
    }

    public void setData(List<ProductEntity> data) {
        this.data = data;
        this.count = data.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
