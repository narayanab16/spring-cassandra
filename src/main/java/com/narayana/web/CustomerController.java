package com.narayana.web;

import com.narayana.model.Customer;
import com.narayana.model.Result;
import com.narayana.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/aggregateByCustomer/{cust_name}")
    public Result aggregateByCustomer(@PathVariable String cust_name) {
        Integer count = customerService.aggregateByCustomer(cust_name);
        Result result = new Result(cust_name, count);

        return result;
    }
    @GetMapping(value = "/deleteCustomerById/{id}")
    public String deleteCustomerById(@PathVariable String id) {
        customerService.deleteCustomerById(id);

        return " customer id : " + id + " deleted";
    }
    @GetMapping(value = "/updateCustomerById/{id}/{cust_name}")
    public String updateCustomerById(@PathVariable String id, @PathVariable String cust_name) {
        customerService.updateCustomerById(id, cust_name);
        return " customer id : " + id + " updated";
    }
    @GetMapping(value = "/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        Optional<Customer> customerById = customerService.getCustomerById(id);

        return customerById.isEmpty() ? new Customer(id,"Customer not exists", "no data") : customerById.get();
    }
    @PostMapping(value = "/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomer(@RequestBody Customer customer) {
        customerService.saveOrUpdate(Arrays.asList(customer));

        return " customer : " + customer.customername() + " added";
    }

    @GetMapping(value = "/getCustomerFullDataById/{id}")
    public List<Customer> getCustomerFullDataById(@PathVariable String id) {
        return customerService.getCustomerFullDataById(id);
    }

}
