package com.narayana;

import com.narayana.model.Customer;
import com.narayana.model.Result;
import com.narayana.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class CassandraDBApplication implements CommandLineRunner {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(CassandraDBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Customer> customerList = new ArrayList<>();
        Customer doc = null;
        for (int i = 1; i <= 30; i++) {
            if(i <=10) {
                doc = new Customer(i + "", "Narayana", "address 1");
            }
            if(i > 10 && i <= 20) {
                doc = new Customer(i + "", "Basetty", "address 2");
            }
            if(i > 20) {
                doc = new Customer(i + "", "Narayana"+i+".com", "address 3");
            }
            customerList.add(doc);
        }
        Boolean status = customerService.saveOrUpdate(customerList);
        if(status)
            LOG.info(" Bulk save - success");
        else
            LOG.info(" Bulk save - failed");
    }


}
