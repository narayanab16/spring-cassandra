package com.narayana.repo;

import com.narayana.model.Customer;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Serializable> {
    @Query(value = "select count(*) from customer where customername=?0 ALLOW FILTERING")
    public Integer aggregateByCustomer(String cust_name);

}
