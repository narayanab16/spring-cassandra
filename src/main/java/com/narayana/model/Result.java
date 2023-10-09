package com.narayana.model;

import java.io.Serializable;

public class Result implements Serializable {
    String customerName;
    Integer count;
    public Result(String customerName, Integer count) {
        this.customerName = customerName;
        this.count = count;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getTotal() {
        return count;
    }
}
