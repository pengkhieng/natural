package com.natural.entity.customer;

import java.util.List;

public class CustomerResponseEntity {
    private List<CustomerEntity> data;
    private int count;

    public CustomerResponseEntity(List<CustomerEntity> data) {
        this.data = data;
        this.count = data.size();
    }

    public List<CustomerEntity> getData() {
        return data;
    }

    public void setData(List<CustomerEntity> data) {
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
