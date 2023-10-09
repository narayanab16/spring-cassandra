package com.narayana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("customer")
public record Customer(@Id String id, String customername, String address) {
}
