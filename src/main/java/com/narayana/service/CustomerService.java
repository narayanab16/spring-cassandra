package com.narayana.service;

import com.narayana.model.Customer;
import com.narayana.model.Result;
import com.narayana.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Boolean saveOrUpdate(List<Customer> custiomersList) {
        List<Customer> list = (List<Customer>) customerRepository.saveAll(custiomersList);
        if(list.size() > 0)
            return true;
        else
            return false;
    }

    public Integer aggregateByCustomer(String customername) {
        return customerRepository.aggregateByCustomer(customername);
    }

    public Boolean deleteCustomerById(@PathVariable String id) {
        customerRepository.deleteById(id);
        return true;
    }
    public Optional<Customer> getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id);
    }
    public Boolean updateCustomerById(@PathVariable String id, String custName) {
        Optional<Customer> cust = customerRepository.findById(id);
        if(cust.isPresent()) {
            Customer custOld = cust.get();
            Customer customer = new Customer(id, custName, custOld.address());
            customerRepository.save(customer);
        }
        return true;
    }
}
