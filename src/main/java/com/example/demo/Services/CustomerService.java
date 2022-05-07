package com.example.demo.Services;

import com.example.demo.Controller.CustomerController;
import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepository customerRepository;
    public void addData(Customer customer) {
        customerRepository.save(customer);
    }

    public List manipulateData(String name) {

      return customerRepository.getAllCustomerData(name);
    }
}
